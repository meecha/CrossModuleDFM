package com.example.flight_contract

import android.content.Context
import android.view.View

interface FlightBooking {
    fun getForm(user: FlightUser, context: Context) : View
}

data class FlightUser(val name :String = "")