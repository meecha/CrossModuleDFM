package com.example.dfmcrosssalemodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.dfmcrosssalemodule.di.DefaultFlightBooking
import com.example.dfmcrosssalemodule.di.DefaultHotelBooking
import com.example.dfmcrosssalemodule.ui.theme.DFMCrossSaleModuleTheme
import com.example.flight_contract.FlightUser
import com.example.hotel_contract.HotelUser

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DFMCrossSaleModuleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen("Rindang Septyan")
                }
            }
        }
    }
}

@Composable
fun HotelBookingForm(user: HotelUser) {
    AndroidView(factory = { context ->
        TravelApplication.DI.manager.hotelBooking.getForm(user, context)
    })
}

@Composable
fun FlightBookingForm(user: FlightUser) {
    AndroidView(factory = { context ->
        TravelApplication.DI.manager.flightBooking.getForm(user, context)
    })
}

@Composable
fun MainScreen(username: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        FlightBookingForm(FlightUser(username))
        HotelBookingForm(HotelUser(username))
    }
}

@Preview(showBackground = true)
@Composable
fun ApplicationPreview() {
    DFMCrossSaleModuleTheme {
        MainScreen("Rindang Septyan")
    }
}