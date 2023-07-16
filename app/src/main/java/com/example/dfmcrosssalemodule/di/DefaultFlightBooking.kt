package com.example.dfmcrosssalemodule.di

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import com.example.dfmcrosssalemodule.R
import com.example.flight_contract.FlightBooking
import com.example.flight_contract.FlightUser

class DefaultFlightBooking : FlightBooking {

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
fun GetDefaultFlightScreen(user: FlightUser) {
    Text(
        text = "Welcome to flight ${user.name}!"
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultFlightBookingPreview() {
    GetDefaultFlightScreen(user = FlightUser("Rindang Septyan"))
}