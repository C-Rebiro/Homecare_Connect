package com.muthoni.homecare_connect.ui.theme.Screens.Register

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.muthoni.homecare_connect.R
import com.muthoni.homecare_connect.data.AuthViewModel
import com.muthoni.homecare_connect.models.UserType
import com.muthoni.homecare_connect.navigation.ROUTE_CLIENT_SCREEN
import com.muthoni.homecare_connect.navigation.ROUTE_HOUSEKEEPER_SCREEN
import com.muthoni.homecare_connect.navigation.ROUTE_LOGIN_SCREEN

fun validateFields(name: String, email: String, pass: String, confirmpass: String, userType: UserType?): Boolean {
    return !name.isBlank() && !email.isBlank() && !pass.isBlank() && pass == confirmpass && userType != null
}

@Composable
fun RegisterScreen(navController: NavHostController) {

    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var userType by remember { mutableStateOf<UserType?>(null) }
    var context = LocalContext.current




    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.backimage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds // or ContentScale.Crop as needed
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Register here",
                color = Color.Black,
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = name, onValueChange = { name = it },
                label = { Text(text = "Enter name",  color = Color.Black) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "name"
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email, onValueChange = { email = it },
                label = { Text(text = "Enter email",  color = Color.Black) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "email"
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = pass, onValueChange = { pass = it },
                label = { Text(text = "Enter password",  color = Color.Black) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "pass"
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = confirmpass, onValueChange = {
                    confirmpass = it
                },
                label = { Text(text = "Enter Confirm Pass", color = Color.Black) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "pass"
                    )
                },

                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            // User type selection
            Text(
                text = "Select User Type:",
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = userType == UserType.Client,
                    onClick = { userType = UserType.Client }
                )
                Text(
                    text = "Client",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier
                )

                RadioButton(
                    selected = userType == UserType.Housekeeper,
                    onClick = { userType = UserType.Housekeeper },
                    modifier = Modifier.padding(start = 16.dp)
                )
                Text(
                    text = "Housekeeper",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier
                )
            }

            Button(
                onClick = {
                    if (validateFields(name.text, email.text, pass.text, confirmpass.text, userType)) {
                        //val authViewModel = AuthViewModel(navController, LocalContext.current)
                        //authViewModel.signup(email.text.trim(), pass.text.trim(), confirmpass.text.trim())
                        when (userType) {
                            UserType.Client -> navController.navigate(ROUTE_CLIENT_SCREEN)
                            UserType.Housekeeper -> navController.navigate(ROUTE_HOUSEKEEPER_SCREEN)
                            null -> TODO()
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Register")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate(ROUTE_LOGIN_SCREEN) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Have an Account? Click to Login")
            }
        }
    }
}

@Composable
@Preview
fun RegisterPreview() {
    RegisterScreen(rememberNavController())
}

fun validateFields(name: TextFieldValue, email: TextFieldValue, password: TextFieldValue, confirmPassword: TextFieldValue, userType: UserType?): Boolean {
    return name.text.isNotBlank() &&
            email.text.isNotBlank() &&
            password.text.isNotBlank() &&
            confirmPassword.text.isNotBlank() &&
            password.text == confirmPassword.text &&
            userType != null
}