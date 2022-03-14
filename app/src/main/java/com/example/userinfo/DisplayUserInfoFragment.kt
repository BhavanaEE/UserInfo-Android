package com.example.userinfo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.userinfo.databinding.FragmentFirstBinding
import java.lang.RuntimeException

class DisplayUserInfoFragment:Fragment(R.layout.activity_display_user) {

    private lateinit var validation: Validation

    @SuppressLint("StringFormatMatches")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = activity?.let { ViewModelProvider(it)[SharedViewModel::class.java] } ?: throw RuntimeException("Not a Activity")

        var outputString = getString(R.string.displayMessage, viewModel.userName.value, viewModel.address.value, viewModel.pinCode.value,viewModel.phoneNumber.value, viewModel.email.value)

        view.findViewById<TextView>(R.id.displayUserInfo).setText(outputString)
    }
}