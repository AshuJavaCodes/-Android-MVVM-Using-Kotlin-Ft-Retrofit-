package com.kotlin.kotlinmvvmfeatretrofit.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.kotlinmvvmfeatretrofit.model.SendOtpModel
import com.kotlin.kotlinmvvmfeatretrofit.repository.MainActivityRepository

class MainActivityViewModel :ViewModel() {

    var verifyOtpLiveData:MutableLiveData<SendOtpModel>?=null


    fun getVerification(context: Context, mobileNumber:String):MutableLiveData<SendOtpModel>{
        verifyOtpLiveData = MainActivityRepository.sendOtp(context, mobileNumber)
        return verifyOtpLiveData as MutableLiveData<SendOtpModel>


    }



}