package com.kotlin.kotlinmvvmfeatretrofit.retrofitServer

import com.kotlin.kotlinmvvmfeatretrofit.model.SendOtpModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    //Writing a Function in kotlin Syntax is
    // fun key word then function name , parameter of the funtion inside brackets and : then the return type of the function.

    @FormUrlEncoded
    @POST("forgot_password")
    fun sendOtp(@Field("mobile") mobileNumber:String):Call<SendOtpModel>

    @FormUrlEncoded
    @POST("verify_otp")
    fun verfiyOtp(@Field("mobile") mobileNumber:String, @Field("otp") otp:String):Call<SendOtpModel>

}