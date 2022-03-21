package com.example.userinfo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(val userName: String, val email: String, val phoneNumber: String, val pinCode:String, val address:String): Parcelable