package com.example.userinfo

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.userinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var validation: Validation
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[SharedViewModel::class.java]

        viewModel.validData.observe(this) { showScreen(it) }

        viewModel.confirmButtonClicked.observe(this) { update -> showDisplayScreen(update) }

        viewModel.cancelButtonClicked.observe(this) { showFragment(R.id.second_container, Fragment(), true)}

    }

    private fun showDisplayScreen(update: Boolean) {
        if (update) {
            showFragment(R.id.second_container, DisplayUserInfoFragment(), true)
        }
    }

    private fun showScreen(update: Boolean) {
        if(!update)
            showFragment(R.id.first_container, FirstFragment(), true)
    }

    private fun showFragment(@IdRes resId: Int, fragment: Fragment, backStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(resId, fragment)
        if (backStack) {
            transaction.addToBackStack("TAG")
        }
        transaction.commit()
    }
}