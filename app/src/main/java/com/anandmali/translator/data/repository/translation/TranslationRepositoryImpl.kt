package com.anandmali.translator.data.repository.translation

import com.anandmali.translator.data.model.Translation
import com.anandmali.translator.util.GenericError
import com.anandmali.translator.util.Result
import com.google.ai.client.generativeai.GenerativeModel
import javax.inject.Inject

class TranslationRepositoryImpl @Inject constructor(
    private val model: GenerativeModel
) : TranslationRepository {
    override suspend fun translate(
        toLanguage: String,
        sentence: String
    ): Result<Translation, GenericError> {
        val prompt = """
            You are an intelligent language translator and information extractor. Your task is to process the given sentence and provide the following information in a structured text format:
            
            1. Translation: The translation of the sentence into the specified language.
            2. Topic: A concise label (1-3 words) representing the main topic of the sentence.
            3. Follow_up_questions:  2-5 relevant follow-up questions that could be asked to explore the topic further.  If no follow-up questions are applicable, return an empty string.
            4. Notes: 2-3 short, concise notes summarizing key information or insights from the sentence. If the sentence is too short to take notes return an empty string.
            
            Sentence: '$sentence'
            Target Language: '$toLanguage'
            
            Output the entire response as a valid text.
            """
        return try {
            val translatedSentence = model.generateContent(prompt = prompt).text
            if (translatedSentence.isNullOrEmpty()) {
                Result.Error(GenericError("Error generating content."))
            } else {
                Result.Success(Translation(translatedSentence))
            }
        } catch (e: Exception) {
            null
            Result.Error(GenericError(e.message!!))
        }
    }

}