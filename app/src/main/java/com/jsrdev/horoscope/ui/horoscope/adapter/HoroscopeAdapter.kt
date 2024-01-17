package com.jsrdev.horoscope.ui.horoscope.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jsrdev.horoscope.databinding.ItemHoroscopeBinding
import com.jsrdev.horoscope.domain.model.HoroscopeInfo

class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList()
) : RecyclerView.Adapter<HoroscopeViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<HoroscopeInfo>) {
        horoscopeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(ItemHoroscopeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val currentHoroscope = horoscopeList[position]
        holder.itemView.setOnClickListener { /* onHoroscopeClicked(currentHoroscope) */ }
        holder.bind(currentHoroscope)
    }
}