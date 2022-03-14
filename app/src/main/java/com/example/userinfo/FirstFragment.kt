package com.example.userinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.userinfo.databinding.FragmentFirstBinding
import java.lang.RuntimeException

class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var validation: Validation
    lateinit var binding:FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        validation= Validation()
        val viewModel = activity?.let {ViewModelProvider(it)[SharedViewModel::class.java]} ?: throw  RuntimeException("Not an activity")

        val myEditTextList = ArrayList<EditText>()

        binding.validateButton.setOnClickListener() {
            viewModel.validateOnClick(myEditTextList,binding)
        }

        viewModel.validData.observe(viewLifecycleOwner){
            modifyVisibility(it)
//            viewModel.setUserData(binding.userNameEt.text.toString(),binding.emailEt.text.toString(),Integer.parseInt(binding.numberEt.text.toString()),Integer.parseInt(binding.pincodeEt.text.toString()),binding.addressEt.text.toString())
        }
        binding.confirmButton.setOnClickListener() {
//            viewModel.setUserData(binding.userNameEt.text.toString(),binding.emailEt.text.toString(),Integer.parseInt(binding.numberEt.text.toString()),Integer.parseInt(binding.pincodeEt.text.toString()),binding.addressEt.text.toString())
            viewModel.setConfirmButtonClicked(true)
        }
        binding.cancelButton.setOnClickListener() {
            viewModel.setValidData(false)
        }
    }

    fun modifyVisibility(
        visibility: Boolean,
    ) {
        binding.addressEt.isEnabled=!visibility
        binding.pincodeEt.isEnabled=!visibility
        binding.numberEt.isEnabled=!visibility
        binding.emailEt.isEnabled=!visibility
        binding.userNameEt.isEnabled=!visibility
        binding.validateButton.visibility = if (visibility) View.GONE else View.VISIBLE
        binding.groupButton.visibility = if (!visibility) View.GONE else View.VISIBLE
    }
}
