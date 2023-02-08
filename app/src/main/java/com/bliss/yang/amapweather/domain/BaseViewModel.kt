package com.bliss.yang.amapweather.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(){
    private val progressBarStatus = MutableLiveData<Boolean>()

    fun getProgressBarStatus() : MutableLiveData<Boolean> {
        return progressBarStatus
    }

}