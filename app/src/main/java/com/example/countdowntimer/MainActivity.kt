package com.example.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.countdowntimer.databinding.ActivityMainBinding
import com.example.countdowntimer.databinding.LayoutLandscapeBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = TimeAdapter()
    private lateinit var chronometer: Chronometer
    private var pauseAt: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        chronometer = binding.numberTimeChronometr
        init()
    }

    private fun init(){
        binding.apply {
            recyclerRes.layoutManager = GridLayoutManager(this@MainActivity, 2)
            recyclerRes.adapter = adapter
            bStart.setOnClickListener {
                chronometer.base = SystemClock.elapsedRealtime() - pauseAt
                chronometer.start()
                bStart.visibility = View.INVISIBLE
                bRestart.visibility = View.VISIBLE
                bStop.setOnClickListener {
                    chronometer.stop()
                    bStop.visibility = View.GONE
                    bContinue.visibility = View.VISIBLE
                }
            }

            imBatPlus.setOnClickListener {
                val timeAyt = Time(numberTimeChronometr.text.toString())
                adapter.addTime(timeAyt)
            }

            imButDel.setOnClickListener {
                adapter.addTime(null)
            }

            bRestart.setOnClickListener {
                bContinue.visibility = View.GONE
                bStop.visibility = View.VISIBLE
                chronometer.base = SystemClock.elapsedRealtime()
                chronometer.start()
            }

            bContinue.setOnClickListener {
                chronometer.start()
                bContinue.visibility = View.GONE
                bStop.visibility = View.VISIBLE
            }
        }
    }
}