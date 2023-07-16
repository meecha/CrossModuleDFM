package com.example.hotel.ui

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
import com.example.dfmcrosssalemodule.di.GetDefaultHotelScreen
import com.example.hotel_contract.HotelBooking
import com.example.hotel_contract.HotelUser

class HotelBookingImpl : HotelBooking {
    override fun getForm(user: HotelUser, context: Context): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.default_form, null, false)
        val compose: ComposeView = view.findViewById(R.id.compose_view)
        compose.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    GetDefaultHotelScreen(user)
                }
            }
        }
        return view
    }
}

@Composable
fun GetHotelBookingForm(user: HotelUser) {
    Column {
        Text(
            text = "Hotel Form"
        )
        Text(
            text = "Booked by ${user.name}"
        )
        Text(
            text = "Jakarta "
        )
        Text(
            text = "JHL Solitaire - Junior Suite"
        )
        Text(
            text = "3D2N"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HotelBookingPreview() {
    GetHotelBookingForm(user = HotelUser("Rindang Septyan"))
}