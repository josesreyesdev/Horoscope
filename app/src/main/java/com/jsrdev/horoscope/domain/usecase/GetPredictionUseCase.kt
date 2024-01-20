package com.jsrdev.horoscope.domain.usecase

import com.jsrdev.horoscope.domain.Repository
import javax.inject.Inject

// GetPredictionUseCase o GetPredictionInteractor el vm le pide al usecase y
// este le pide al domain(cerebro)
class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    // Invoke se llama desde viewModel sin invocarlo, automaticamente se llama al
    // ser instanciado mi clase usecase
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}