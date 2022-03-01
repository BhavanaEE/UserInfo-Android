package com.example.userinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    val pincodePattern = Pattern.compile("^[1-9][0-9]{5}$")
    val emailPattern=Pattern.compile("^[A-za-z0-9_.-]+@[a-z]+\\.+(com|co.in)")
    val userNamePattern=Pattern.compile("^[A-za-z0-9 ]*")
    val phoneNumberPattern=Pattern.compile("^[1-9][0-9]{9}")
    var visibility=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userName = findViewById<EditText>(R.id.userNameEt)
        val email = findViewById<EditText>(R.id.emailEt)
        val number = findViewById<EditText>(R.id.numberEt)
        val pincode = findViewById<EditText>(R.id.pincodeEt)
        val address = findViewById<EditText>(R.id.addressEt)
        val validate = findViewById<Button>(R.id.buttonLabel)
        val cancel=findViewById<Button>(R.id.cancelButton)
        val confirm=findViewById<Button>(R.id.confirmButton)

        validate.setOnClickListener() {
            val isAllFieldsChecked = checkAllFields(userName,email,number,pincode,address)
            if (isAllFieldsChecked) {
                val validateResult=validateAllFields(userName,email,number,pincode,address)
                if (validateResult) {
                    visibility=false
                    modifyVisibility(userName,email,number,pincode,address,validate,cancel,confirm,visibility)

                }
            }
            confirm.setOnClickListener() {
                if (isAllFieldsChecked) {
                    val validateResult=validateAllFields(userName,email,number,pincode,address)
                    if (validateResult) {
                        val intent = Intent(this, DisplayUserInfoActivity::class.java)
                        intent.putExtra("USERNAME", userName.text.toString())
                        intent.putExtra("EMAIL", email.text.toString())
                        intent.putExtra("PHONENUMBER", number.text.toString())
                        intent.putExtra("PINCODE", pincode.text.toString())
                        intent.putExtra("ADDRESS", address.text.toString())
                        startActivity(intent)
                    }
                }
            }
            cancel.setOnClickListener() {
                visibility=true
                modifyVisibility(userName, email, number, pincode, address,validate,cancel, confirm, visibility)
            }
        }

    }

    fun validateAllFields(
        userName: EditText,
        email: EditText,
        number: EditText,
        pincode: EditText,
        address: EditText
    ): Boolean {

        if (!isValidEmail(email.text.toString())) {
            callToast( "Invalid Email Address")
            return false
        }
        if (!isValidPinCode(pincode.text.toString())) {
            callToast("Invalid Pincode")
            return false
        }
        if (!isValidPhone(number.text.toString())) {
            callToast("Invalid Phone Number")
            return false
        }
        if(!isValidUserName(userName.text.toString())){
            callToast("Invalid User Name")
            return false
        }
        return true
    }

    private fun callToast(str:String){
        Toast.makeText(applicationContext, str,
            Toast.LENGTH_SHORT).show()
    }

    private fun checkAllFields(
        userName: EditText,
        email: EditText,
        number: EditText,
        pincode: EditText,
        address: EditText
    ): Boolean {

        if (userName.text.trim().isEmpty()) {
            Log.i("UserName", userName.id.toString())
            callToast("Username shouldn't be empty")
            return false
        }
        if (email.text.trim().isEmpty()) {
            callToast("Email shouldn't empty")
            return false
        }
        if(number.text.trim().isEmpty()) {
            callToast("Phone number shouldn't be empty")
            return false
        }
        if(pincode.text.trim().isEmpty()){
            callToast("Pincode shouldn't be empty")
            return false
        }
        if(address.text.trim().isEmpty()){
            callToast("Address shouldn't be empty")
            return false
        }
        return true
    }
    fun isValidEmail(str: String): Boolean {
        return emailPattern.matcher(str).matches()
    }

    fun isValidPinCode(str: String): Boolean {
        return pincodePattern.matcher(str).matches()
    }

    fun isValidPhone(str: String): Boolean {
        return phoneNumberPattern.matcher(str).matches()
    }

    fun isValidUserName(str:String):Boolean{
        return userNamePattern.matcher(str).matches()
    }

    fun modifyVisibility(
        userName:EditText,
        email: EditText,
        number: EditText,
        pincode: EditText,
        address: EditText,
        validate:Button,
        cancel:Button,
        confirm:Button,
        visibility: Boolean
    ){
        userName.isEnabled=visibility
        email.isEnabled=visibility
        pincode.isEnabled=visibility
        number.isEnabled=visibility
        address.isEnabled=visibility
        validate.visibility = if(!visibility) View.GONE else View.VISIBLE
        cancel.visibility = if(visibility) View.GONE else View.VISIBLE
        confirm.visibility =if(visibility) View.GONE else View.VISIBLE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("visibility",visibility)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val v=savedInstanceState.getBoolean("visibility")
        val userName = findViewById<EditText>(R.id.userNameEt)
        val email = findViewById<EditText>(R.id.emailEt)
        val number = findViewById<EditText>(R.id.numberEt)
        val pincode = findViewById<EditText>(R.id.pincodeEt)
        val address = findViewById<EditText>(R.id.addressEt)
        val validate = findViewById<Button>(R.id.buttonLabel)
        val cancel=findViewById<Button>(R.id.cancelButton)
        val confirm=findViewById<Button>(R.id.confirmButton)
        modifyVisibility(userName,email, number, pincode, address,validate, cancel, confirm,v)
    }
}