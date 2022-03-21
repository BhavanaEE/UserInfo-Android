package com.example.userinfo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException

class DisplayUserInfoFragment:Fragment(R.layout.activity_display_user) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = activity?.let { ViewModelProvider(it)[SharedViewModel::class.java] } ?: throw RuntimeException("Not a Activity")

        viewModel.userObject.observe(viewLifecycleOwner){
            displayMessage(it)
        }
    }

    private fun displayMessage(it: User) {
        val outputString  =  getString(R.string.displayMessage, it.userName, it.address, it.pinCode,it.phoneNumber, it.email)
        view?.findViewById<TextView>(R.id.displayUserInfo)?.text = outputString

    }
}