package com.example.userinfo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayUserInfoActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_user)
        val getUserName=intent.getStringExtra(USERNAME)
        val getEmail=intent.getStringExtra(EMAIL)
        val getPhoneNumber=intent.getStringExtra(PHONENUMBER)
        val getPincode=intent.getStringExtra(PINCODE)
        val getAddress=intent.getStringExtra(ADDRESS)
        val outputString="Hi "+getUserName+", How are you? Are you staying at "+getAddress+"-"+getPincode+"code. I am not able to contact you on "+getPhoneNumber+". Can I email you the details at "+getEmail
        findViewById<TextView>(R.id.displayUserInfo).setText(outputString)
    }
}