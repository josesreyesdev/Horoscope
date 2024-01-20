package com.jsrdev.horoscope.ui.detail

sealed class HoroscopeDetailState {
    data object Loading: HoroscopeDetailState()
    data class Error(val error: String): HoroscopeDetailState()
    data class Success(val data: String, val sign: String): HoroscopeDetailState()
}