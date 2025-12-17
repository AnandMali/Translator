package com.anandmali.translator.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anandmali.translator.domain.usecase.language.LanguageUseCase
import com.anandmali.translator.domain.usecase.translation.TranslationUseCase
import com.anandmali.translator.presentation.state.UiState
import com.anandmali.translator.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TranslatorViewModel @Inject constructor(
    private val languageUseCase: LanguageUseCase,
    private val translationUseCase: TranslationUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Initial)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _speechLanguage: MutableStateFlow<String> = MutableStateFlow("English (Default)")
    val speechLanguage: StateFlow<String> = _speechLanguage.asStateFlow()

    fun translateText(target: String, data: String) {
        _uiState.value = UiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = translationUseCase.translate(target, data)) {
                is Result.Success -> {
                    _uiState.value = UiState.Success(result.value.translatedText)
                }

                is Result.Error -> {
                    _uiState.value = UiState.Error(result.value.errorMessage)
                }
            }
        }
    }

    fun getLanguageOfText(data: String) {
        viewModelScope.launch {
            _speechLanguage.value = "Recognising the language ..."
            when (val result = languageUseCase.getLanguage(data)) {
                is Result.Success -> {
                    _speechLanguage.value = result.value.language
                }

                is Result.Error -> {
                    _speechLanguage.value = result.value.errorMessage
                }
            }
        }
    }
}