package com.example.flight.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import com.example.dfmcrosssalemodule.R
import com.example.dfmcrosssalemodule.di.GetDefaultFlightScreen
import com.example.flight_contract.FlightBooking
import com.example.flight_contract.FlightUser

class FlightBookingImpl : FlightBooking {
    override fun getForm(user: FlightUser, context: Context): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.default_form, null, false)
        val compose: ComposeView = view.findViewById(R.id.compose_view)
        compose.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    GetDefaultFlightScreen(user)
                }
            }
        }
        return view
    }
}

@Composable
fun GetFlightBookingForm(user: FlightUser) {
    Column {
        Text(
            text = "Flight Form"
        )
        Text(
            text = "Passenger name ${user.name}"
        )
        Text(
            text = "Bangkok --> Jakarta"
        )
        Text(
            text = "25 September 2023"
        )
        Text(
            text = "Garuda Indonesia            15.50 --> 19.20"
        )
        Text(
            text = "Economy - Direct "
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FlightBookingPreview() {
    GetFlightBookingForm(user = FlightUser("Rindang Septyan"))
}