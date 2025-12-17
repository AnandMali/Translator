package com.anandmali.translator.domain.usecase.translation

import com.anandmali.translator.data.model.Translation
import com.anandmali.translator.data.repository.translation.TranslationRepository
import com.anandmali.translator.util.GenericError
import com.anandmali.translator.util.Result
import javax.inject.Inject

class TranslationUseCaseImpl @Inject constructor(
    private val repository: TranslationRepository
) : TranslationUseCase {
    override suspend fun translate(
        toLanguage: String,
        sentence: String
    ): Result<Translation, GenericError> {
        return repository.translate(toLanguage, sentence)
    }
}
