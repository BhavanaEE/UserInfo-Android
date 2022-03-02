package com.example.userinfo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun enteredFieldsWithProperValidationsOrNot() {
        onView(withId(R.id.userNameEt)).perform(typeText("Bhavana"), closeSoftKeyboard())
        onView(withId(R.id.emailEt)).perform(typeText("bhavana@gmail.com"),closeSoftKeyboard())
        onView(withId(R.id.numberEt)).perform(typeText("1234567893"),closeSoftKeyboard())
        onView(withId(R.id.pincodeEt)).perform(typeText("123456"),closeSoftKeyboard())
        onView(withId(R.id.addressEt)).perform(typeText("Hyderabad"),closeSoftKeyboard())
        onView(withId(R.id.buttonLabel)).perform(ViewActions.click())
        onView(withId(R.id.userNameEt))
            .check(ViewAssertions.matches(ViewMatchers.withText("Bhavana")))
        onView(withId(R.id.emailEt))
            .check(ViewAssertions.matches(ViewMatchers.withText("bhavana@gmail.com")))
        onView(withId(R.id.numberEt))
            .check(ViewAssertions.matches(ViewMatchers.withText("1234567893")))
        onView(withId(R.id.pincodeEt))
            .check(ViewAssertions.matches(ViewMatchers.withText("123456")))
        onView(withId(R.id.addressEt))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hyderabad")))
    }

    @Test
    fun testToDisplayMessageAfterConfirmButton() {
        onView(withId(R.id.userNameEt)).perform(typeText("Bhavana"), closeSoftKeyboard())
        onView(withId(R.id.emailEt)).perform(typeText("bhavana@gmail.com"),closeSoftKeyboard())
        onView(withId(R.id.numberEt)).perform(typeText("1234567893"),closeSoftKeyboard())
        onView(withId(R.id.pincodeEt)).perform(typeText("123456"),closeSoftKeyboard())
        onView(withId(R.id.addressEt)).perform(typeText("Hyderabad"),closeSoftKeyboard())
        onView(withId(R.id.buttonLabel)).perform(ViewActions.click())
        onView(withId(R.id.confirmButton)).perform(ViewActions.click())
        onView(withId(R.id.displayUserInfo)).check(ViewAssertions.matches(ViewMatchers.withText("Hi "+"Bhavana"+", How are you? Are you staying at "+"Hyderabad"+"-"+"123456"+"code. I am not able to contact you on "+"1234567893"+". Can I email you the details at "+"bhavana@gmail.com")))

    }

    @Test
    fun testToDisplayFieldsAfterCancelButton(){
        onView(withId(R.id.userNameEt)).perform(typeText("Bhavana"), closeSoftKeyboard())
        onView(withId(R.id.emailEt)).perform(typeText("bhavana@gmail.com"),closeSoftKeyboard())
        onView(withId(R.id.numberEt)).perform(typeText("1234567893"),closeSoftKeyboard())
        onView(withId(R.id.pincodeEt)).perform(typeText("123456"),closeSoftKeyboard())
        onView(withId(R.id.addressEt)).perform(typeText("Hyderabad"),closeSoftKeyboard())
        onView(withId(R.id.buttonLabel)).perform(ViewActions.click())
        onView(withId(R.id.cancelButton)).perform(ViewActions.click())
        onView(withId(R.id.userNameEt))
            .check(ViewAssertions.matches(ViewMatchers.withText("Bhavana")))
        onView(withId(R.id.emailEt))
            .check(ViewAssertions.matches(ViewMatchers.withText("bhavana@gmail.com")))
        onView(withId(R.id.numberEt))
            .check(ViewAssertions.matches(ViewMatchers.withText("1234567893")))
        onView(withId(R.id.pincodeEt))
            .check(ViewAssertions.matches(ViewMatchers.withText("123456")))
        onView(withId(R.id.addressEt))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hyderabad")))
    }

}