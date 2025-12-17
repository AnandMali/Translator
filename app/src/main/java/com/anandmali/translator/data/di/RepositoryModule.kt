package com.anandmali.translator.data.di

import com.anandmali.translator.data.repository.language.LanguageRepository
import com.anandmali.translator.data.repository.language.LanguageRepositoryImpl
import com.anandmali.translator.data.repository.translation.TranslationRepository
import com.anandmali.translator.data.repository.translation.TranslationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindTranslationRepository(
        translationRepositoryImpl: TranslationRepositoryImpl
    ): TranslationRepository

    @Singleton
    @Binds
    abstract fun bindLanguageRepository(
        languageRepositoryImpl: LanguageRepositoryImpl
    ): LanguageRepository
}