package com.muthoni.homecare_connect.ui.theme.Screens.Services

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.muthoni.homecare_connect.R

@Composable
fun DeepCleaning(navController: NavHostController) {
    Text(text = "A Good Combination",
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HomeDeepCleaning(
                imagePainter = painterResource(id = R.drawable.livingarea),
                title = "cleaning of the living and dining area ",
                charge = "5000",

                )
        }
        item {
            HomeDeepCleaning(
                imagePainter = painterResource(id = R.drawable.seats),
                title = "Vacuum of the house and seats",
                charge = "5000",


                )
        }
        item {
            HomeDeepCleaning(
                imagePainter = painterResource(id = R.drawable.kitchen),
                title = "Arranging the pantry, fridge and decluttering of the kitchen area",
                charge = "10,000",

                )
        }
        item {
            HomeDeepCleaning(
                imagePainter = painterResource(id = R.drawable.lawn),
                title = "mowing the lawn ",
                charge = "4000",

                )

        }
        item {
            HomeDeepCleaning(
                imagePainter = painterResource(id = R.drawable.declutter),
                title = "Decluttering of more than 3 bedrooms",
                charge = "4200"
                )
        }
        item {
            HomeDeepCleaning(
                imagePainter = painterResource(id = R.drawable.fourbedroom),
                title = "Decluttering of less than three bedrooms",
                charge = "3500",

                )
        }


    }
}

@Composable
fun HomeDeepCleaning(
    title: String = "",
    charge: String = "",
    imagePainter: Painter
) {
    Card(
        Modifier
            .fillMaxWidth()
            .width(160.dp)
    ) {
        Column(
            Modifier
                .padding(bottom = 32.dp)
        ) {
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Row {
                    Text(
                        "Kes ${charge}"
                    )


                }
                Spacer(modifier = Modifier.height(8.dp))
                // A button
                Button(
                    onClick = {/* navigated page*/ },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Buy This - Kes $charge")
                }
            }
        }
    }
}



@Preview
@Composable
private fun DeepCleaningprev() {
    DeepCleaning(rememberNavController())


}