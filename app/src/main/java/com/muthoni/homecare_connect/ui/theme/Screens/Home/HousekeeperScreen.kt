package com.muthoni.homecare_connect.ui.theme.Screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.muthoni.homecare_connect.R

@Composable
fun HousekeeperScreen(navController: NavHostController) {
    // State for location and hourly rate
    val (location, setLocation) = remember { mutableStateOf("") }
    val (hourlyRate, setHourlyRate) = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.homeimage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
            // Crop as needed
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text(
                text = "Welcome to Homecare Connect",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Matched for Cleanliness",
                color = Color.Unspecified,
                fontFamily = FontFamily.SansSerif,
                fontSize = 25.sp
            )

            // Location input field
            OutlinedTextField(
                value = location,
                onValueChange = { setLocation(it) },
                label = { Text("Enter Location") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Hourly rate input field
            OutlinedTextField(
                value = hourlyRate,
                onValueChange = { setHourlyRate(it) },
                label = { Text("Enter Hourly Rate") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Button to accept request
            Button(
                onClick = {
                    // You can perform action to accept the request here
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Accept Request")
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .background(Color.White.copy(0.4f))
        ) {
            Text(
                text = "Why Homecare Connect?",
                color = Color.Unspecified,
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Homecare Connect offers the utmost convenience for both clients and housekeepers. Clients can easily find reliable housekeepers in their area without the hassle of searching through multiple platforms or agencies. Likewise, housekeepers can connect with clients who are seeking their services, all within one user-friendly app.",
                fontSize = 10.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Preview
@Composable
private fun Housekeeperprev() {
    HousekeeperScreen(rememberNavController())

}