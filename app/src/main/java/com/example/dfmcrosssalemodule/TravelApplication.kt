package com.example.dfmcrosssalemodule

import com.example.dfmcrosssalemodule.di.DIAppManager
import com.example.dfmcrosssalemodule.di.DefaultFlightBooking
import com.example.dfmcrosssalemodule.di.DefaultHotelBooking
import com.google.android.play.core.splitcompat.SplitCompatApplication

class TravelApplication : SplitCompatApplication() {

    object DI {
        lateinit var manager: DIAppManager
    }

    override fun onCreate() {
        super.onCreate()
        initComponents()
    }

    private fun initComponents(){
        DI.manager = DIAppManager()
        DI.manager.flightBooking = DefaultFlightBooking()
        DI.manager.hotelBooking = DefaultHotelBooking()
    }
}