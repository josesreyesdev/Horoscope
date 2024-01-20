package com.jsrdev.horoscope.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.jsrdev.horoscope.R
import com.jsrdev.horoscope.databinding.ActivityHoroscopeDetailBinding
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Aquarius
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Aries
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Cancer
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Capricorn
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Gemini
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Leo
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Libra
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Pisces
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Sagittarius
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Scorpio
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Taurus
import com.jsrdev.horoscope.domain.model.HoroscopeModel.Virgo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding

    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        horoscopeDetailViewModel.getHoroscopeDetail(args.currentHoroscope)

        initUi()
    }

    private fun initUi() {
        initListeners()
        initUIState()
    }

    @Suppress("DEPRECATION")
    private fun initListeners() {
        binding.imageBack.setOnClickListener { onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect { state ->
                    when (state) {
                        is HoroscopeDetailState.Error -> errorState()
                        HoroscopeDetailState.Loading -> loadingState(true)
                        is HoroscopeDetailState.Success -> successState(state)
                    }
                }
            }
        }
    }

    private fun loadingState(showProgressBar: Boolean) {
        binding.progressBar.isVisible = showProgressBar
    }

    private fun errorState() {
        loadingState(false)
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        loadingState(false)

        binding.title.text = state.sign
        binding.textBody.text = state.data

        val horoscopeImg = when (state.horoscopeModel) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }

        binding.imageDetail.setImageResource(horoscopeImg)
    }
}