package com.example.lesson8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.lesson8.viewModel.MyViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = MyViewModel(this)
        viewModel.message.observeForever {
            findViewById<TextView>(R.id.text_error).text = it
        }
        findViewById<Button>(R.id.button_send).setOnClickListener {
            viewModel.getPin(findViewById<EditText>(R.id.editTextNumberPassword).text.toString())
        }

    }
}