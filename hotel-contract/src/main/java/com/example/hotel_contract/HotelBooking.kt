package com.example.hotel_contract

import android.content.Context
import android.view.View

interface HotelBooking {
    fun getForm(user: HotelUser, context: Context) : View
}

data class HotelUser(val name: String = "")