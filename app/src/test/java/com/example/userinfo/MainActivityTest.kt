package com.example.userinfo

import android.widget.EditText
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityTest {

    @MockK
    private lateinit var mainActivity: MainActivity

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        mainActivity = MainActivity()
    }

    @Test
    fun isValidEmail() {
        assertTrue(mainActivity.isValidEmail("bhavana@gmail.com"))
    }
    @Test
    fun isNotValidEmail(){
        assertFalse(mainActivity.isValidEmail("bhavana@gmail.co"))
    }
    @Test
    fun isValidPinCode() {
        assertTrue(mainActivity.isValidPinCode("500059"))
    }
    @Test
    fun isNotValidPinCode(){
        assertFalse(mainActivity.isValidPinCode("123"))
    }
    @Test
    fun isValidPhone() {
        assertTrue(mainActivity.isValidPhone("9087654321"))
    }
    @Test
    fun isNotValidPhone(){
        assertFalse(mainActivity.isValidPhone("123446"))
    }

    @Test
    fun isValidUserName() {
        assertTrue(mainActivity.isValidUserName("Bhavana Chivukula"))
    }
    @Test
    fun isNotValidUserName(){
        assertFalse(mainActivity.isValidUserName("@bhlamk &(0b"))
    }
}