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
fun Laundry(navController: NavHostController) {
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
            Laundry(
                imagePainter = painterResource(id = R.drawable.onsite),
                title = "On premises laundry",
                charge = "3800",

                )
        }

        item {
            Laundry(
                imagePainter = painterResource(id = R.drawable.offsite),
                title = "Off premises",
                charge = "3000",

                )
        }
        item {
            Laundry(
                imagePainter = painterResource(id = R.drawable.curtain),
                title = "Curtain Vaccuming",
                charge = "5000",

                )
        }
        item {
            Laundry(
                imagePainter = painterResource(id = R.drawable.textile),
                title = "Textile cleaning",
                charge = "7200",

                )
        }

    }
}

@Composable
fun Laundry(
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
private fun Laundryprev() {
    Laundry(rememberNavController())


}