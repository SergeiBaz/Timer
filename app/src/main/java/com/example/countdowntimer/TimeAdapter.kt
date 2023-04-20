package com.example.countdowntimer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countdowntimer.databinding.TimeItemBinding

class TimeAdapter: RecyclerView.Adapter<TimeAdapter.TimeHolder>() {
    private val timeList = ArrayList<Time>()
    class TimeHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = TimeItemBinding.bind(item)
        fun bind(time: Time) = with(binding){
            textTime.text = time.timeTimer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.time_item, parent, false)
        return TimeHolder(view)
    }

    override fun getItemCount(): Int {
        return timeList.size
    }

    override fun onBindViewHolder(holder: TimeHolder, position: Int) {
        holder.bind(timeList[position])
    }

    fun addTime(time: Time?){
        if (time == null) timeList.clear()
        if (time != null) {
            timeList.add(time)
        }
        notifyDataSetChanged()
    }
}