package com.jsrdev.horoscope.ui.horoscope.adapter

import androidx.recyclerview.widget.RecyclerView
import com.jsrdev.horoscope.databinding.ItemHoroscopeBinding
import com.jsrdev.horoscope.domain.model.HoroscopeInfo

class HoroscopeViewHolder(private var binding: ItemHoroscopeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(horoscopeInfo: HoroscopeInfo) {
        val context = binding.horoscopeTitle.context
        binding.apply {
            horoscopeImage.setImageResource(horoscopeInfo.img)
            horoscopeTitle.text = context.getString(horoscopeInfo.name)
        }
    }
}