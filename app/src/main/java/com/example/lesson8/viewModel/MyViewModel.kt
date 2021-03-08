package com.example.lesson8.viewModel

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson8.model.Model

class MyViewModel(context: Context) : ViewModel() {
    val message = MutableLiveData<String>()
    private val model = Model(context)
    fun getPin(pin : String) {
        if (model.pinIsTrue(pin)) {
            message.postValue("True")
        } else {
            startTimer()
        }
    }
    fun startTimer() {
        object : CountDownTimer(model.getTime(), 1000) {
            override fun onFinish() {
                message.postValue("")
                model.saveTime(10000)
            }
            override fun onTick(millisUntilFinished: Long) {
                message.postValue("Left: ${millisUntilFinished/1000}")
                model.saveTime(millisUntilFinished)
            }
        }.start()
    }
}