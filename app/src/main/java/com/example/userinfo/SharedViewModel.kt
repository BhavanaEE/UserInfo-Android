package com.example.userinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userinfo.databinding.FragmentFirstBinding

class SharedViewModel:ViewModel() {

    private var user: User = User("","","","","")

    private var _user=MutableLiveData(user)
    val userObject:LiveData<User> = _user

    private  val _confirmButtonCLicked=MutableLiveData(false)
    val confirmButtonClicked:LiveData<Boolean> = _confirmButtonCLicked

    private val _validData = MutableLiveData(false)
    val validData: LiveData<Boolean> = _validData

    private val _cancelButtonClicked = MutableLiveData(false)
    val cancelButtonClicked: LiveData<Boolean> = _cancelButtonClicked

    fun setValidData(b: Boolean) {
        this._validData.postValue(b)
    }

    fun setCancelButtonClicked(b: Boolean) {
        this._cancelButtonClicked.postValue(b)
    }

    fun setConfirmButtonClicked(b: Boolean) {
       this._confirmButtonCLicked.postValue(b)
    }

    fun validateOnClick(binding: FragmentFirstBinding) {
        this.user=User(binding.userNameEt.text.toString(),binding.emailEt.text.toString(),binding.numberEt.text.toString(),binding.pinCodeEt.text.toString(),binding.addressEt.text.toString())
        setValidData(true)
        setUsersData(user)
    }

    private fun setUsersData(userObject: User) {
        this._user.postValue(userObject)
    }
}