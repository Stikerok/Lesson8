package com.example.lesson8.model

import android.content.Context


const val PINN = "1245"
class Model (context: Context) {
    val sp = context.getSharedPreferences("App", Context.MODE_PRIVATE)
    fun saveTime(mill : Long) {
        sp.edit().putLong("time",mill).apply()
    }
    fun getTime() : Long {
        return sp.getLong("time",10000)
    }
    fun pinIsTrue(pin : String) : Boolean {
        return PINN == pin
    }

}