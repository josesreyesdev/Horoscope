package com.jsrdev.horoscope.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jsrdev.horoscope.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}