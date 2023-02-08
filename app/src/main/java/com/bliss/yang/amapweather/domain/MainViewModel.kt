package com.bliss.yang.amapweather.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bliss.yang.amapweather.api.ApiService
import com.bliss.yang.amapweather.data.Weather
import com.bliss.yang.amapweather.network.RetrofitFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {
    private val beijingResult = MutableLiveData<Weather>()
    private val shanghaiResult = MutableLiveData<Weather>()
    private val guangzhouResult = MutableLiveData<Weather>()
    private val shenzhenResult = MutableLiveData<Weather>()
    private val suzhouResult = MutableLiveData<Weather>()
    private val shenyangResult = MutableLiveData<Weather>()
    private val service = RetrofitFactory.instance.getService(ApiService::class.java)

    fun getBeijingWeatherResult() : MutableLiveData<Weather> {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO){
                    service.getWeatherResult("北京")
                }
                beijingResult.postValue(data.body())
            }catch (e:Exception){
                e.printStackTrace()
                Log.e("net error","网络请求错误${e.toString()}")
            }
        }
        return beijingResult
    }

    fun getShenzhenWeatherResult() : MutableLiveData<Weather> {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO){
                    service.getWeatherResult("深圳")
                }
                shenzhenResult.postValue(data.body())
            }catch (e:Exception){
                e.printStackTrace()
                Log.e("net error","网络请求错误${e.toString()}")
            }
        }
        return shenzhenResult
    }

    fun getShanghaiWeatherResult() : MutableLiveData<Weather> {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO){
                    service.getWeatherResult("上海")
                }
                shanghaiResult.postValue(data.body())
            }catch (e:Exception){
                e.printStackTrace()
                Log.e("net error","网络请求错误${e.toString()}")
            }
        }
        return shanghaiResult
    }

    fun getGuangzhouWeatherResult() : MutableLiveData<Weather> {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO){
                    service.getWeatherResult("广州")
                }
                guangzhouResult.postValue(data.body())
            }catch (e:Exception){
                e.printStackTrace()
                Log.e("net error","网络请求错误${e.toString()}")
            }
        }
        return guangzhouResult
    }

    fun getSuzhouWeatherResult() : MutableLiveData<Weather> {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO){
                    service.getWeatherResult("苏州")
                }
                suzhouResult.postValue(data.body())
            }catch (e:Exception){
                e.printStackTrace()
                Log.e("net error","网络请求错误${e.toString()}")
            }
        }
        return suzhouResult
    }

    fun getShenyangWeatherResult() : MutableLiveData<Weather> {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO){
                    service.getWeatherResult("沈阳")
                }
                shenyangResult.postValue(data.body())
            }catch (e:Exception){
                e.printStackTrace()
                Log.e("net error","网络请求错误${e.toString()}")
            }
        }
        return shenyangResult
    }
}