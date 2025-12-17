package com.anandmali.translator.domain.di

import com.anandmali.translator.domain.usecase.language.LanguageUseCase
import com.anandmali.translator.domain.usecase.language.LanguageUseCaseImpl
import com.anandmali.translator.domain.usecase.translation.TranslationUseCase
import com.anandmali.translator.domain.usecase.translation.TranslationUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Singleton
    @Binds
    abstract fun bindLanguageUseCase(
        languageUseCaseImpl: LanguageUseCaseImpl
    ): LanguageUseCase

    @Singleton
    @Binds
    abstract fun bindTranslationUseCase(
        translationUseCaseImpl: TranslationUseCaseImpl
    ): TranslationUseCase

}