package com.kotlin.kotlinmvvmfeatretrofit.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.kotlin.kotlinmvvmfeatretrofit.model.SendOtpModel
import com.kotlin.kotlinmvvmfeatretrofit.retrofitServer.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {
    val sendOtpModelMutableLiveData = MutableLiveData<SendOtpModel>()

    //Calling the Api to Send the Otp to Required Number.
    fun sendOtp(context:Context,mobileNumber:String): MutableLiveData<SendOtpModel>{
        var call:Call<SendOtpModel>
        call = RetrofitService().apiInterface.sendOtp(mobileNumber)
        call.enqueue(object : Callback<SendOtpModel>{
            override fun onResponse(call: Call<SendOtpModel>, response: Response<SendOtpModel>) {
                var message:String
                var data =  response.body()
                message = data!!.message.toString()

                //Dont Forget to do this Else you wont Get Any Return Data.
                //Itslike .postValue(response.body) in Java.
                sendOtpModelMutableLiveData.value = response.body()


            }

            override fun onFailure(call: Call<SendOtpModel>, t: Throwable) {

                Log.i("INFO :",t.message.toString())
            }
        })
        return sendOtpModelMutableLiveData
    }






}