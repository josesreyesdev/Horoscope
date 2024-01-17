package com.jsrdev.horoscope.ui.horoscope

import androidx.lifecycle.ViewModel
import com.jsrdev.horoscope.domain.model.*
import com.jsrdev.horoscope.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.math.abs


@HiltViewModel
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = listOf(
            Aries, Taurus, Virgo
        )
    }

    fun getHoroscopes() {
        abs(2)
    }
}