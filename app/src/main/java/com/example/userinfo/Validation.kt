package com.example.userinfo

import android.widget.Toast
import java.util.regex.Pattern

class Validation {
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

}