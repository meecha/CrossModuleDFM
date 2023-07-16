package com.example.dfmcrosssalemodule

import android.util.Log
import com.example.dfmcrosssalemodule.di.DIAppManager
import com.example.dfmcrosssalemodule.di.DefaultFlightBooking
import com.example.dfmcrosssalemodule.di.DefaultHotelBooking
import com.example.flight_contract.FlightBooking
import com.example.hotel_contract.HotelBooking
import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import kotlin.reflect.full.createInstance

class TravelApplication : SplitCompatApplication() {

    object DI {
        lateinit var manager: DIAppManager
    }

    override fun onCreate() {
        super.onCreate()
        initComponents()
    }

    /**
     * They add this as official docs now as we raise it on 2018 back then.
     * We show them 2 option to instantiate object cross split module
     * 1. to use Android system (Broadcast, Service, etc)
     * 2. to just simply using Reflection
     * https://developer.android.com/guide/playcore/feature-delivery/on-demand#access_code_different_module
     */
    private fun initComponents() {
        DI.manager = DIAppManager()
        DI.manager.flightBooking = DefaultFlightBooking()
        DI.manager.hotelBooking = DefaultHotelBooking()

        val man = SplitInstallManagerFactory.create(this)
        man.installedModules.forEach {
            Log.d("installed Split", "split name : $it, starting initiate the module")
            when (it) {
                "flight" -> {
                    DI.manager.flightBooking =
                        (Class.forName("com.example.flight.ui.FlightBookingFactory").kotlin.createInstance() as FlightBooking)
                }

                "hotel" -> {
                    DI.manager.hotelBooking =
                        (Class.forName("com.example.hotel.ui.HotelBookingFactory").kotlin.createInstance() as HotelBooking)
                }
            }
            Log.d("installed Split", "split name : $it, success initiate the module")
        }
    }
}
