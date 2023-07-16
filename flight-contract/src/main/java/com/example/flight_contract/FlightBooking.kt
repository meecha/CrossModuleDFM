package com.example.flight_contract

import android.view.View

interface FlightBooking {
    fun getForm(user: FlightUser) : View
}

data class FlightUser(val name :String)