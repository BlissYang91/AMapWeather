package com.bliss.yang.amapweather.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bliss.yang.amapweather.R
import com.bliss.yang.amapweather.databinding.ActivityMainBinding
import com.bliss.yang.amapweather.domain.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        viewModel.getBeijingWeatherResult().observe(this, Observer {
            Log.d(TAG, "initView: getWeatherResult ytf ===  $it")
            if (it.error_code == 0) {
                val realtime = it.result.realtime
                binding.tvBeijing.text = "北京 :  ${realtime.temperature}摄氏度, ${realtime.info}, ${realtime.direct} ${realtime.power}"
            }
        })
        viewModel.getShanghaiWeatherResult().observe(this, Observer {
            Log.d(TAG, "initView: getWeatherResult ytf ===  $it")
            if (it.error_code == 0) {
                val realtime = it.result.realtime
                binding.tvShanghai.text = "上海 :  ${realtime.temperature}摄氏度, ${realtime.info}, ${realtime.direct} ${realtime.power}"
            }
        })
        viewModel.getGuangzhouWeatherResult().observe(this, Observer {
            Log.d(TAG, "initView: getWeatherResult ytf ===  $it")
            if (it.error_code == 0) {
                val realtime = it.result.realtime
                binding.tvGuangzhou.text = "广州 :  ${realtime.temperature}摄氏度, ${realtime.info}, ${realtime.direct} ${realtime.power}"
            }
        })
        viewModel.getShenzhenWeatherResult().observe(this, Observer {
            Log.d(TAG, "initView: getWeatherResult ytf ===  $it")
            if (it.error_code == 0) {
                val realtime = it.result.realtime
                binding.tvShenzhen.text = "深圳 :  ${realtime.temperature}摄氏度, ${realtime.info}, ${realtime.direct} ${realtime.power}"
            }
        })
        viewModel.getSuzhouWeatherResult().observe(this, Observer {
            Log.d(TAG, "initView: getWeatherResult ytf ===  $it")
            if (it.error_code == 0) {
                val realtime = it.result.realtime
                binding.tvSuzhou.text = "苏州 :  ${realtime.temperature}摄氏度, ${realtime.info}, ${realtime.direct} ${realtime.power}"
            }
        })
        viewModel.getShenyangWeatherResult().observe(this, Observer {
            Log.d(TAG, "initView: getWeatherResult ytf ===  $it")
            if (it.error_code == 0) {
                val realtime = it.result.realtime
                binding.tvShenyang.text = "沈阳 :  ${realtime.temperature}摄氏度, ${realtime.info}, ${realtime.direct} ${realtime.power}"
            }
        })
    }
}