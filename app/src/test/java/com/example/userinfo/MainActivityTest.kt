//package com.example.userinfo
//
//import android.util.Log
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import io.mockk.impl.annotations.MockK
//import org.junit.Assert.*
//import org.junit.Before
//import org.junit.Rule
//
//import org.junit.Test
//import org.junit.rules.TestRule
//import org.junit.runner.RunWith
//import org.junit.runners.JUnit4
//
//@RunWith(JUnit4::class)
//class MainActivityTest {
//
//    @MockK
//    private var mainActivity: MainActivity = MainActivity()
//    private var userName:EditText=EditText(this.mainActivity)
//    private var email:EditText= EditText(this.mainActivity)
//    private var number:EditText= EditText(this.mainActivity)
//    private var pincode:EditText= EditText(this.mainActivity)
//    private var address:EditText= EditText(this.mainActivity)
//
//    @get:Rule
//    var rule: TestRule = InstantTaskExecutorRule()
//
//    @Before
//    fun setUp() {
//        mainActivity = MainActivity()
//////        userName.setText("Bhavana")
//////        email.setText("bhavana@gmail.com")
//////        number.setText("1234567890")
//////        pincode.setText("123456")
//////        address.setText("Hyderabad")
//    }
//
//    @Test
//    fun isValidEmail() {
//        assertTrue(mainActivity.isValidEmail("bhavana@gmail.com"))
//    }
//    @Test
//    fun isNotValidEmail(){
//        assertFalse(mainActivity.isValidEmail("bhavana@gmail.co"))
//    }
//    @Test
//    fun isValidPinCode() {
//        assertTrue(mainActivity.isValidPinCode("500059"))
//    }
//    @Test
//    fun isNotValidPinCode(){
//        assertFalse(mainActivity.isValidPinCode("123"))
//    }
//    @Test
//    fun isValidPhone() {
//        assertTrue(mainActivity.isValidPhone("9087654321"))
//    }
//    @Test
//    fun isNotValidPhone(){
//        assertFalse(mainActivity.isValidPhone("123446"))
//    }
//
//    @Test
//    fun isValidUserName() {
//        assertTrue(mainActivity.isValidUserName("Bhavana Chivukula"))
//    }
//    @Test
//    fun isNotValidUserName(){
//        assertFalse(mainActivity.isValidUserName("@bhlamk &(0b"))
//    }
//    @Test
//    fun testToCheckAllFields(){
////        val u=userName.findViewById<EditText>(R.id.userNameEt)
////        val e=email.findViewById<EditText>(R.id.emailEt)
////        val num=number.findViewById<EditText>(R.id.numberEt)
////        val pin=pincode.findViewById<EditText>(R.id.pincodeEt)
////        val addr=address.findViewById<EditText>(R.id.addressEt)
//        userName.setText("Bhavana")
//        email.setText("bhavana@gmail.com")
//        number.setText("1234567893")
//        pincode.setText("123456")
//        address.setText("Hyderabad")
//        assertTrue(mainActivity.checkAllFields(userName, email, number, pincode, address))
//    }
////    private fun checkAllFields(
////        userName: EditText,
////        email: EditText,
////        number: EditText,
////        pincode: EditText,
////        address: EditText
////    ): Boolean {
////
////        if (userName.text.trim().isEmpty()) {
////            Log.i("UserName", userName.id.toString())
////            callToast("Username shouldn't be empty")
////            return false
////        }
////        if (email.text.trim().isEmpty()) {
////            callToast("Email shouldn't empty")
////            return false
////        }
////        if(number.text.trim().isEmpty()) {
////            callToast("Phone number shouldn't be empty")
////            return false
////        }
////        if(pincode.text.trim().isEmpty()){
////            callToast("Pincode shouldn't be empty")
////            return false
////        }
////        if(address.text.trim().isEmpty()){
////            callToast("Address shouldn't be empty")
////            return false
////        }
////        return true
////    }
//}