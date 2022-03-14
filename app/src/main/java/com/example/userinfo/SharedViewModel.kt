package com.example.userinfo

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userinfo.databinding.FragmentFirstBinding

class SharedViewModel:ViewModel() {

    private lateinit var validation: Validation

    private val _userName = MutableLiveData("")
    val userName: LiveData<String> = _userName

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _phoneNumber = MutableLiveData(0)
    val phoneNumber: LiveData<Int> = _phoneNumber

    private val _pinCode = MutableLiveData(0)
    val pinCode: LiveData<Int> = _pinCode

    private val _address = MutableLiveData("")
    val address: LiveData<String> = _address

    private  val _confirmButtonCLicked=MutableLiveData(false)
    val confirmButtonClicked:LiveData<Boolean> = _confirmButtonCLicked

    private val _validData = MutableLiveData(false)
    val validData: LiveData<Boolean> = _validData

    private val _loadScreen=MutableLiveData(true)
    val loadScreenInfo:LiveData<Boolean> = _loadScreen

    fun setLoadScreen(b:Boolean){
        this._loadScreen.postValue(b)
    }

    fun getLoadScreen(): Boolean? {
        return this._loadScreen.value
    }

    fun setValidData(b: Boolean) {
        this._validData.postValue(b)
    }

    fun setConfirmButtonClicked(b: Boolean) {
       this._confirmButtonCLicked.postValue(b)
    }

     fun setUserData(userName: String, email: String, phoneNumber: Int, pinCode: Int, address: String) {
        this._userName.postValue(userName)
        this._email.postValue(email)
        this._phoneNumber.postValue(phoneNumber)
        this._pinCode.postValue(pinCode)
        this._address.postValue(address)
    }

    fun validateOnClick(myEditTextList: ArrayList<EditText>, binding: FragmentFirstBinding) {
        this.validation = Validation()
        for (i in 0 until binding.constraintLayout.childCount){
            if (binding.constraintLayout.getChildAt(i) is EditText){
                myEditTextList.add(binding.constraintLayout.getChildAt(i) as EditText)}}
        val validateResult= this.validation.validateAllFields(myEditTextList)
        if (validateResult) {
            setValidData(true)
            setUserData(binding.userNameEt.text.toString(),binding.emailEt.text.toString(),Integer.parseInt(binding.numberEt.text.toString()),Integer.parseInt(binding.pincodeEt.text.toString()),binding.addressEt.text.toString())
        }
    }
}