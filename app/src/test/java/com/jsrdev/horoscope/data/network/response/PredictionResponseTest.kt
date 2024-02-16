package com.jsrdev.horoscope.data.network.response

import com.jsrdev.horoscope.horoscopeMotherObjec.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test

class PredictionResponseTest {

    @Test
    fun `toDomain should return a correct PredictionModel`() {
        //Given
        val horoscopeResponse = anyResponse //.copy(sign = "libra")

        //When
        val predictionModel = horoscopeResponse.toDomain()

        //Them
        predictionModel.sign shouldBe  horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}