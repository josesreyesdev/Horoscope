package com.jsrdev.horoscope.ui.detail

import com.jsrdev.horoscope.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object Loading: HoroscopeDetailState()
    data class Error(val error: String): HoroscopeDetailState()
    data class Success(val data: String, val sign: String, val horoscopeModel: HoroscopeModel): HoroscopeDetailState()
}