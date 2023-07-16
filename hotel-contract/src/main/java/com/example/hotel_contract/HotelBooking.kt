package com.example.hotel_contract

import android.view.View

interface HotelBooking {
    fun getForm(user: HotelUser) : View
}

data class HotelUser(val name: String)