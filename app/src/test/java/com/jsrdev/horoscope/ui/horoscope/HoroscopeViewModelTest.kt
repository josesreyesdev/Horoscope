package com.jsrdev.horoscope.ui.horoscope

import com.jsrdev.horoscope.data.providers.HoroscopeProvider
import com.jsrdev.horoscope.horoscopeMotherObjec.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest {

    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun when_viewModel_is_created_then_horoscopes_are_loaded() {
        every { horoscopeProvider.getHoroscope() } returns horoscopeInfoList //listOf(), si getHorocope no es corrutina llamarlo con every
        //coEvery { horoscopeProvider.getHoroscope() } return listOf() // si getHoroscope es con currutina llamarlo con coEvery
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscopes = viewModel.horoscope.value

        assert(horoscopes.isNotEmpty())
    }
}