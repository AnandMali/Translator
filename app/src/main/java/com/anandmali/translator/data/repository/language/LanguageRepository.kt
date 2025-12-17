package com.anandmali.translator.data.repository.language

import com.anandmali.translator.data.model.Language
import com.anandmali.translator.util.GenericError
import com.anandmali.translator.util.Result

interface LanguageRepository {
    suspend fun getLanguages(
        sentence: String
    ): Result<Language, GenericError>
}
