package com.kotlin.kotlinmvvmfeatretrofit.model

import com.google.gson.annotations.SerializedName

data class SendOtpModel( @SerializedName("code"    ) var code    : Int?    = null,
                         @SerializedName("status"  ) var status  : String? = null,
                         @SerializedName("message" ) var message : String? = null


) {
    override fun toString(): String {
        return "SendOtpModel(message=$message)"
    }
}
