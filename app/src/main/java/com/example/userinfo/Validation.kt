package com.example.userinfo

import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class Validation() {
    var pincodePattern: Pattern = Pattern.compile("^[1-9][0-9]{5}$")
    var emailPattern: Pattern = Pattern.compile("^[A-za-z0-9_.-]+@[a-z]+\\.+(com|co.in)")
    var userNamePattern: Pattern = Pattern.compile("^[A-za-z0-9 ]*")
    var phoneNumberPattern: Pattern = Pattern.compile("^[1-9][0-9]{9}")

    fun isValidEmail(str: String): Boolean {
        return emailPattern.matcher(str).matches()
    }

    fun isValidPinCode(str: String): Boolean {
        return pincodePattern.matcher(str).matches()
    }

    fun isValidPhone(str: String): Boolean {
        return phoneNumberPattern.matcher(str).matches()
    }

    fun isValidUserName(str: String): Boolean {
        return userNamePattern.matcher(str).matches()
    }

//    fun callToast(str: String) {
//        Toast.makeText(this, str,
//            Toast.LENGTH_SHORT).show()
//    }

    private fun isFieldEmpty(toString: String): Boolean {
        return toString.trim().isEmpty()
    }

    fun checkAllFields(fields: ArrayList<EditText>): Boolean {
        for (field in fields) {
            if (isFieldEmpty(field.text.toString())) {
//                callToast(field.hint.toString())
                Log.i("bhbsh",isFieldEmpty(field.text.toString()).toString())
                return false
            }
        }
        return true
    }

    fun validateAllFields(
        fields: ArrayList<EditText>
    ): Boolean {
        if(checkAllFields(fields)) {
            if (!isValidUserName(fields[0].text.toString())) {
//                callToast(getString(R.string.invalidUserName))
                return false
            }
            if (!isValidEmail(fields[1].text.toString())) {
//                callToast(getString(R.string.invalidEmail))
                return false
            }
            if (!isValidPhone(fields[2].text.toString())) {
//                callToast(getString(R.string.invalidPhoneNumber))
                return false
            }
            if (!isValidPinCode(fields[3].text.toString())) {
//                callToast(getString(R.string.invalidPincode))
                return false
            }

        }
        return true
    }
}
