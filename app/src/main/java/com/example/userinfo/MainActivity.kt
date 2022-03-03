package com.example.userinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var validation:Validation
    var visibility=true

    override fun onCreate(savedInstanceState: Bundle?) {
        validation = Validation()

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
            val isAllFieldsChecked = checkAllFields(userName.text.toString(),email.text.toString(),number.text.toString(),pincode.text.toString(),address.text.toString())
            if (isAllFieldsChecked) {
                val validateResult=validateAllFields(userName.text.toString(),email.text.toString(),number.text.toString(),pincode.text.toString())
                if (validateResult) {
                    visibility=false
                    modifyVisibility(userName,email,number,pincode,address,validate,cancel,confirm,visibility)
                }
            }
            confirm.setOnClickListener() {
                if (isAllFieldsChecked) {
                    val validateResult=validateAllFields(userName.text.toString(),email.text.toString(),number.text.toString(),pincode.text.toString())
                    if (validateResult) {
                        val intent = Intent(this, DisplayUserInfoActivity::class.java)
                        intent.putExtra(USERNAME, userName.text.toString())
                        intent.putExtra(EMAIL, email.text.toString())
                        intent.putExtra(PHONENUMBER, number.text.toString())
                        intent.putExtra(PINCODE, pincode.text.toString())
                        intent.putExtra(ADDRESS, address.text.toString())
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
        userName: String,
        email: String,
        number: String,
        pincode: String,
    ): Boolean {

        if (!validation.isValidEmail(email)) {
            callToast( "Invalid Email Address")
            return false
        }
        if (!validation.isValidPinCode(pincode)) {
            callToast("Invalid Pincode")
            return false
        }
        if (!validation.isValidPhone(number)) {
            callToast("Invalid Phone Number")
            return false
        }
        if(!validation.isValidUserName(userName)){
            callToast("Invalid User Name")
            return false
        }
        return true
    }

     fun callToast(str:String){
        Toast.makeText(applicationContext, str,
            Toast.LENGTH_SHORT).show()
    }

    fun checkAllFields(
        userName: String,
        email: String,
        number: String,
        pinCode: String,
        address: String
    ): Boolean {

        if (userName.trim().isEmpty()) {
            Log.i("UserName", userName)
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
        return true
    }

    fun modifyVisibility(
        userName:EditText,
        email: EditText,
        number: EditText,
        pinCode: EditText,
        address: EditText,
        validate:Button,
        cancel:Button,
        confirm:Button,
        visibility: Boolean
    ){
        userName.isEnabled=visibility
        email.isEnabled=visibility
        pinCode.isEnabled=visibility
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