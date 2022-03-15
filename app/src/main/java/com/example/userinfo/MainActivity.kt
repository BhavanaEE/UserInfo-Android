package com.example.userinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.userinfo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var validation: Validation
    private lateinit var binding: ActivityMainBinding


    var visibility: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        validation = Validation(this)


        val myEditTextList = ArrayList<EditText>()

        validation.checkAllFields(myEditTextList)

        super.onCreate(savedInstanceState)
        val validate = binding.validateButton

        validate.setOnClickListener() {
            for (i in 0 until binding.constraintLayout.childCount)
                if (binding.constraintLayout.getChildAt(i) is EditText)
                    myEditTextList.add(binding.constraintLayout.getChildAt(i) as EditText)
            val validateResult = validation.validateAllFields(myEditTextList)
            if (validateResult) {
                visibility = false
                modifyVisibility(validate, visibility)
            }
        }
        binding.confirmButton.setOnClickListener() {
            val intent = Intent(this, DisplayUserInfoActivity::class.java)
            val user = User(binding.userNameEt.text.toString(), binding.emailEt.text.toString(), binding.numberEt.text.toString(), binding.pincodeEt.text.toString(), binding.addressEt.text.toString())
            intent.putExtra(USERDETAILS, user)
            startActivity(intent)
        }
        binding.cancelButton.setOnClickListener() {
            visibility = true
            modifyVisibility(validate, visibility)
        }
    }

    fun modifyVisibility(
        validate: Button,
        visibility: Boolean,
    ) {
        binding.addressEt.isEnabled = visibility
        binding.pincodeEt.isEnabled = visibility
        binding.numberEt.isEnabled = visibility
        binding.emailEt.isEnabled = visibility
        binding.userNameEt.isEnabled = visibility
        validate.visibility = if (!visibility) View.GONE else View.VISIBLE
        binding.groupButton.visibility = if (visibility) View.GONE else View.VISIBLE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("visibility", visibility)

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val v = savedInstanceState.getBoolean("visibility")
        modifyVisibility(binding.validateButton, v)
    }
}