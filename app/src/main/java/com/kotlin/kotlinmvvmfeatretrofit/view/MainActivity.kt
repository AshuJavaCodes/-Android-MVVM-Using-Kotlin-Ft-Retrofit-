package com.kotlin.kotlinmvvmfeatretrofit.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlin.kotlinmvvmfeatretrofit.R
import com.kotlin.kotlinmvvmfeatretrofit.databinding.ActivityMainBinding
import com.kotlin.kotlinmvvmfeatretrofit.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    //Creating a ViewBinding Variable in kotlin.
    lateinit var  binding:ActivityMainBinding
    lateinit var context: Context
    lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setting the View Binding in kotlin.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this@MainActivity
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.btnVerifyOtp.setOnClickListener {
            //Calling the verfiy otp Api When the Button is Clicked.\
            mainActivityViewModel.getVerification(context,binding.edtPhoneNumber.text.toString())!!.observe(this,
                Observer {
                    binding.tvStatus.setText(it.message)
                    Toast.makeText(context,"Send Otp",Toast.LENGTH_LONG).show()
                })
        }
    }
}