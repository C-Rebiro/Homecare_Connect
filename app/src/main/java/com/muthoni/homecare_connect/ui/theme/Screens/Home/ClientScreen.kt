package com.muthoni.homecare_connect.ui.theme.Screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.muthoni.homecare_connect.navigation.ROUTE_DEEP_CLEANING
import com.muthoni.homecare_connect.navigation.ROUTE_LAUNDRY

@Composable
fun ClientScreen(navController: NavHostController) {
    // State for location and budget
    val (location, setLocation) = remember { mutableStateOf("") }
    val (budget, setBudget) = remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) } // Initialize expanded state

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.homeimage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds // or ContentScale.Crop as needed
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                // Your logout icon here
                // For example, if you are using material icons
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Logout",
                    modifier = Modifier.padding(end = 16.dp)
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    DropdownMenuItem(
                        text = { Text("Personal Information") },
                        // handle personal information
                        onClick = { expanded = false })
                    DropdownMenuItem(
                        text = { Text("Log out") },
                        //handle log out
                        onClick = { expanded = false })

                }

            }
            // Title
            Text(
                text = "Welcome to Homecare Connect",
                color = Color.White,
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(bottom = 16.dp, top = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Matched for Cleanliness",
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 25.sp
            )

            OutlinedTextField(
                value = location,
                onValueChange = { setLocation(it) },
                label = { Text("Enter Location") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "location"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = location,
                onValueChange = { setLocation(it) },
                label = { Text("Enter Budget") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "budget"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )



            Button(
                onClick = { navController.navigate(ROUTE_DEEP_CLEANING)
                    // You can navigate to the next screen or perform action here
                },
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 24.dp)
            ) {

                Text("View deep cleaning Services")
            }

            Button(
                onClick = { navController.navigate(ROUTE_LAUNDRY)
                    // You can navigate to the next screen or perform action here
                },
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 24.dp)
            ) {

                Text("View laundry Services")
            }


            // Button to navigate to next screen or perform action
            Button(
                onClick = {
                    // You can navigate to the next screen or perform action here
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Callings had")
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
private fun Clientscreenprev() {
    ClientScreen(rememberNavController())
}