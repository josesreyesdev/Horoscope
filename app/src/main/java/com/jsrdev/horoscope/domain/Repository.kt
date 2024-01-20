package com.jsrdev.horoscope.domain

import com.jsrdev.horoscope.domain.model.PredictionModel

/* Comunicación entre data y dominio  */

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}