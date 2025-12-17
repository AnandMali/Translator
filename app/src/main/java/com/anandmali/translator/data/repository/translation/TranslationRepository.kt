package com.anandmali.translator.data.repository.translation

import com.anandmali.translator.data.model.Translation
import com.anandmali.translator.util.GenericError
import com.anandmali.translator.util.Result

interface TranslationRepository {
    suspend fun translate(
        toLanguage: String,
        sentence: String
    ): Result<Translation, GenericError>
}