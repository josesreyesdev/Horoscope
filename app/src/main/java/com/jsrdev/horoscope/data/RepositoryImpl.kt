package com.jsrdev.horoscope.data

import android.util.Log
import com.jsrdev.horoscope.data.network.HoroscopeApiService
import com.jsrdev.horoscope.domain.Repository
import com.jsrdev.horoscope.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("RepositoryImpl", "Ha ocurrido un error ${it.message}") }
        return null
    }
}