package com.jsrdev.horoscope.horoscopeMotherObjec

import com.jsrdev.horoscope.data.network.response.PredictionResponse
import com.jsrdev.horoscope.domain.model.HoroscopeInfo

object HoroscopeMotherObject {
    val anyResponse = PredictionResponse("date", "prediction", "taurus" )

    val horoscopeInfoList = listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Virgo,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Pisces
    )
}