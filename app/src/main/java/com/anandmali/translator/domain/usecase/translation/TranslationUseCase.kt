package com.anandmali.translator.domain.usecase.translation

import com.anandmali.translator.data.model.Translation
import com.anandmali.translator.util.GenericError
import com.anandmali.translator.util.Result

interface TranslationUseCase {
    suspend fun translate(
        toLanguage:String,
        sentence:String
    ): Result<Translation, GenericError>
}