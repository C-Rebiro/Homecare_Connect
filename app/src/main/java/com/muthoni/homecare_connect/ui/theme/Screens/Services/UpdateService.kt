package com.muthoni.homecare_connect.ui.theme.Screens.Services

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.muthoni.homecare_connect.data.ServiceViewModel

@Composable
fun UpdateService(navController: NavHostController, id:String) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var name by remember { mutableStateOf("") }
        var charge by remember { mutableStateOf("") }

        var currentDataRef = FirebaseDatabase.getInstance().getReference()
            .child("Service/$id")
        currentDataRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var service = snapshot.getValue(com.muthoni.homecare_connect.models.Service::class.java)
                name = service!!.name
                charge = service!!.charge
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        Text(
            text = "Add service",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var serviceName by remember { mutableStateOf(TextFieldValue(name)) }
        var serviceCharge by remember { mutableStateOf(TextFieldValue(charge)) }

        OutlinedTextField(
            value = serviceName,
            onValueChange = { serviceName = it },
            label = { Text(text = "Service name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            value = serviceCharge,
            onValueChange = { serviceCharge = it },
            label = { Text(text = "Service charge") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            var serviceRepository = ServiceViewModel(navController, context)
            serviceRepository.updateService(serviceName.text.trim(),
                serviceCharge.text.trim(),id)


        }) {
            Text(text = "Update")
        }

    }
}

@Preview
@Composable
fun Updateservprev() {
    UpdateService(rememberNavController(), id = "")
}

