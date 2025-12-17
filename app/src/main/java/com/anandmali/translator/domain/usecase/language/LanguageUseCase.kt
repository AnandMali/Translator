package com.anandmali.translator.domain.usecase.language

import com.anandmali.translator.data.model.Language
import com.anandmali.translator.util.GenericError
import com.anandmali.translator.util.Result

interface LanguageUseCase {
    suspend fun getLanguage(
        sentence: String
    ): Result<Language, GenericError>
}
