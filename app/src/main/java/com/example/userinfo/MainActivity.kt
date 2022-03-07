package com.example.userinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
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

        super.onCreate(savedInstanceState)
        val validate = binding.validateButton

        validate.setOnClickListener() {
            val validateResult = validation.checkAndValidateFields(binding.userNameEt.text.toString(),
                binding.emailEt.text.toString(),
                binding.numberEt.text.toString(),
                binding.pincodeEt.text.toString(),
                binding.addressEt.text.toString())
            if (validateResult) {
                visibility = false
                modifyVisibility( validate, visibility)
            }
        }
        binding.confirmButton.setOnClickListener() {
            val intent = Intent(this, DisplayUserInfoActivity::class.java)
            intent.putExtra(USERNAME, binding.userNameEt.text.toString())
            intent.putExtra(EMAIL, binding.emailEt.text.toString())
            intent.putExtra(PHONENUMBER, binding.numberEt.text.toString())
            intent.putExtra(PINCODE, binding.pincodeEt.text.toString())
            intent.putExtra(ADDRESS, binding.addressEt.text.toString())
            startActivity(intent)
        }
        binding.cancelButton.setOnClickListener() {
            visibility = true
            modifyVisibility( validate, visibility)
        }
    }

    fun modifyVisibility(
        validate: Button,
        visibility: Boolean,
    ) {
        binding.addressEt.isEnabled=visibility
        binding.pincodeEt.isEnabled=visibility
        binding.numberEt.isEnabled=visibility
        binding.emailEt.isEnabled=visibility
        binding.userNameEt.isEnabled=visibility
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