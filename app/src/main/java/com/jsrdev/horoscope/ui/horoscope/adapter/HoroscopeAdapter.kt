package com.jsrdev.horoscope.ui.horoscope.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.jsrdev.horoscope.databinding.ItemHoroscopeBinding
import com.jsrdev.horoscope.domain.model.HoroscopeInfo

class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onHoroscopeClicked: (HoroscopeInfo) -> Unit
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
        startRotationAnimation(view = holder.itemView, newLambda = {onHoroscopeClicked(currentHoroscope)})
        holder.itemView.setOnClickListener { onHoroscopeClicked(currentHoroscope) }
        holder.bind(currentHoroscope)
    }

    private fun startRotationAnimation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLambda() }
            start()
        }
    }
}