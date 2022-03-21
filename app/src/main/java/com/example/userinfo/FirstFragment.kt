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
    ): View {
        binding= FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        validation= Validation(requireActivity())
        val viewModel = activity?.let {ViewModelProvider(it)[SharedViewModel::class.java]} ?: throw  RuntimeException("Not an activity")

        val myEditTextList = ArrayList<EditText>()

        binding.validateButton.setOnClickListener() {
            validateOnClick(myEditTextList,viewModel)
        }

        viewModel.validData.observe(viewLifecycleOwner){
            modifyVisibility(it)
        }

        binding.confirmButton.setOnClickListener() {
            viewModel.setConfirmButtonClicked(true)
        }

        binding.cancelButton.setOnClickListener() {
            viewModel.setValidData(false)
            viewModel.setCancelButtonClicked(true)
        }
    }

    private fun validateOnClick(myEditTextList: ArrayList<EditText>, viewModel: SharedViewModel) {
        for (i in 0 until binding.constraintLayout.childCount){
            if (binding.constraintLayout.getChildAt(i) is EditText){
                myEditTextList.add(binding.constraintLayout.getChildAt(i) as EditText)}}

        val checkAllFields = this.validation.checkAllFields(myEditTextList)
        if(checkAllFields){
            val validateAllFields = validation.validateAllFields(myEditTextList)
            if(validateAllFields){
                viewModel.validateOnClick(binding)
            }
        }
    }

    fun modifyVisibility(
        visibility: Boolean,
    ) {
        binding.addressEt.isEnabled=!visibility
        binding.pinCodeEt.isEnabled=!visibility
        binding.numberEt.isEnabled=!visibility
        binding.emailEt.isEnabled=!visibility
        binding.userNameEt.isEnabled=!visibility
        binding.validateButton.visibility = if (visibility) View.GONE else View.VISIBLE
        binding.groupButton.visibility = if (!visibility) View.GONE else View.VISIBLE
    }
}
