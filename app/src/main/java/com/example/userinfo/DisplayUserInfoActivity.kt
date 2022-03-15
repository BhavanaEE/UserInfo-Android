package com.example.userinfo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayUserInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_user)
        val userDetails = intent.extras?.getParcelable<User>(USERDETAILS)
        findViewById<TextView>(R.id.displayUserInfo).text =
            getString(
                R.string.displayMessage,
                userDetails?.userName,
                userDetails?.address,
                userDetails?.pinCode,
                userDetails?.phoneNumber,
                userDetails?.email
            )
    }
}