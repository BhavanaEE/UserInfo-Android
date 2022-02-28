package com.example.userinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userName = findViewById<EditText>(R.id.userNameEt)
        val email = findViewById<EditText>(R.id.emailEt)
        val number = findViewById<EditText>(R.id.numberEt)
        val pincode = findViewById<EditText>(R.id.pincodeEt)
        val address = findViewById<EditText>(R.id.addressEt)
        val validate = findViewById<Button>(R.id.buttonLabel)
        val cancel = findViewById<Button>(R.id.cancelButton)
        val confirm = findViewById<Button>(R.id.confirmButton)
    }
}