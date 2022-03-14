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

//        val transaction1 = supportFragmentManager.beginTransaction()
//        transaction1.replace(R.id.first_container,FirstFragment())
//        transaction1.commit()

        val viewModel = ViewModelProvider(this)[SharedViewModel::class.java]
//        if(viewModel.getLoadScreen() == true) {
//            viewModel.loadScreenInfo.observe(this) {
//                    update -> loadScreen(update)
//                viewModel.setLoadScreen(false)
//            }
//        }

        viewModel.confirmButtonClicked.observe(this) { update ->
            showScreen(update)
        }
    }

    private fun loadScreen(update: Boolean?) {
        showFragment(R.id.first_container,FirstFragment(),true)
    }

    private fun showScreen(update: Boolean) {
        if (update) {
            showFragment(R.id.second_container, DisplayUserInfoFragment(), true)
        }
        else
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