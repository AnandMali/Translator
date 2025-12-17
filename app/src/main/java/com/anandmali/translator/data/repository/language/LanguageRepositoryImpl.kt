package com.anandmali.translator.data.repository.language

import com.anandmali.translator.data.model.Language
import com.anandmali.translator.util.GenericError
import com.anandmali.translator.util.Result
import com.google.ai.client.generativeai.GenerativeModel
import javax.inject.Inject

class LanguageRepositoryImpl @Inject constructor(
    private val model: GenerativeModel
) : LanguageRepository {
    override suspend fun getLanguages(
        sentence: String
    ): Result<Language, GenericError> {
        val prompt = """
            You are a language translator. Identify language of given sentence '$sentence'.
            Sentence: '$sentence'
            Return only one name of the language. If you do not know the language of the sentence, return 'Unknown' word as language.
            """
        return try {
            val language = model.generateContent(prompt = prompt).text
            if (language.isNullOrEmpty()) {
                return Result.Error(GenericError("Error generating content."))
            } else {
                Result.Success(Language(language))
            }
        } catch (e: Exception) {
            Result.Error(GenericError(e.message ?: "Exception while getting language."))
        }
    }
}