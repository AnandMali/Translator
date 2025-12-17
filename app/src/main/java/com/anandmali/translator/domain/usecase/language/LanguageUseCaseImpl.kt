package com.anandmali.translator.domain.usecase.language

import com.anandmali.translator.data.model.Language
import com.anandmali.translator.data.repository.language.LanguageRepository
import com.anandmali.translator.util.GenericError
import com.anandmali.translator.util.Result
import javax.inject.Inject

class LanguageUseCaseImpl @Inject constructor(
    private val repository: LanguageRepository
): LanguageUseCase {
    override suspend fun getLanguage(sentence: String): Result<Language, GenericError> {
        return repository.getLanguages(sentence)
    }
}