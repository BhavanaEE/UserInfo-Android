package com.example.userinfo

import android.content.Context
import android.content.ContextWrapper
import android.widget.Toast
import java.util.regex.Pattern

class Validation(base: Context?) : ContextWrapper(base){
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

    fun callToast(str: String) {
        Toast.makeText(this, str,
            Toast.LENGTH_SHORT).show()
    }
    fun checkAndValidateFields(
        userName: String,
        email: String,
        number: String,
        pinCode: String,
        address: String,
    ): Boolean {
        if (userName.trim().isEmpty()) {
            callToast("Username shouldn't be empty")
            return false
        }
        if (email.trim().isEmpty()) {
            callToast("Email shouldn't empty")
            return false
        }
        if (number.trim().isEmpty()) {
            callToast("Phone number shouldn't be empty")
            return false
        }
        if (pinCode.trim().isEmpty()) {
            callToast("Pincode shouldn't be empty")
            return false
        }
        if (address.trim().isEmpty()) {
            callToast("Address shouldn't be empty")
            return false
        }
        if (!isValidUserName(userName)) {
            callToast("Invalid User Name")
            return false
        }
        if (!isValidEmail(email)) {
            callToast("Invalid Email Address")
            return false
        }
        if (!isValidPhone(number)) {
            callToast("Invalid Phone Number")
            return false
        }
        if (!isValidPinCode(pinCode)) {
            callToast("Invalid Pincode")
            return false
        }
        return true
    }
}
