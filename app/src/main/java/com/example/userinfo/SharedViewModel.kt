package com.example.userinfo

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userinfo.databinding.FragmentFirstBinding

class SharedViewModel:ViewModel() {

    private lateinit var validation: Validation

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

    fun validateOnClick(myEditTextList: ArrayList<EditText>, binding: FragmentFirstBinding) {
        this.validation = Validation()
        this.user=User(binding.userNameEt.text.toString(),binding.emailEt.text.toString(),binding.numberEt.text.toString(),binding.pincodeEt.text.toString(),binding.addressEt.text.toString())

        for (i in 0 until binding.constraintLayout.childCount){
            if (binding.constraintLayout.getChildAt(i) is EditText){
                myEditTextList.add(binding.constraintLayout.getChildAt(i) as EditText)}}
        val validateResult= this.validation.validateAllFields(myEditTextList)
        if (validateResult) {
            setValidData(true)
            setUsersData(user)
        }
    }

    private fun setUsersData(userObject: User) {
        this._user.postValue(userObject)
    }
}