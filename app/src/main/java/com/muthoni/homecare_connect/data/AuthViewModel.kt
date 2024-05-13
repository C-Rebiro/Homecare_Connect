package com.muthoni.homecare_connect.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.muthoni.homecare_connect.navigation.ROUTE_CLIENT_SCREEN
import com.muthoni.homecare_connect.navigation.ROUTE_HOUSEKEEPER_SCREEN
import com.muthoni.homecare_connect.navigation.ROUTE_LOGIN_SCREEN
import com.muthoni.homecare_connect.navigation.ROUTE_REGISTER_SCREEN


class AuthViewModel(var navController: NavHostController, var context: Context) {

    private var mAuth: FirebaseAuth
    private val progress: ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please Wait.....")
    }

    fun signup(name: String, email: String, pass: String, confirmPass: String) {
        progress.show()

        if (name.isBlank() || email.isBlank() || pass.isBlank() || confirmPass.isBlank()) {
            progress.dismiss()
            Toast.makeText(context, "Name, email, and password cannot be blank", Toast.LENGTH_LONG).show()
            return
        } else if (pass != confirmPass) {
            progress.dismiss()
            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_LONG).show()
            return
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val currentUser = mAuth.currentUser
                    if (currentUser != null) {
                        val userId = currentUser.uid
                        val userData = User(email, pass, confirmPass)
                        val regRef = FirebaseDatabase.getInstance().getReference().child("Users").child(userId)
                        regRef.setValue(userData).addOnCompleteListener { regTask ->
                            if (regTask.isSuccessful) {
                                progress.dismiss()
                                Toast.makeText(context, "Registered Successfully", Toast.LENGTH_LONG).show()
                                navController.navigate(ROUTE_LOGIN_SCREEN)
                            } else {
                                progress.dismiss()
                                Toast.makeText(context, "Failed to register user", Toast.LENGTH_LONG).show()
                                navController.navigate(ROUTE_REGISTER_SCREEN)
                            }
                        }
                    }
                } else {
                    progress.dismiss()
                    Toast.makeText(context, "${task.exception?.message}", Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_LOGIN_SCREEN)
                }
            }
        }
    }

    private fun User(email: String, pass: String, confirmPass: String): Any? {
return User(email, pass, confirmPass)   }


    fun login(email: String, pass: String) {
        progress.show()

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
            progress.dismiss()
            if (task.isSuccessful) {
                Toast.makeText(context, "Successfully Logged in", Toast.LENGTH_LONG).show()
                val currentUser = mAuth.currentUser
                if (currentUser != null) {
                    val userEmail = currentUser.email ?: ""
                    // Check the user type and navigate accordingly
                    if (isClient(userEmail)) {
                        navController.navigate(ROUTE_CLIENT_SCREEN) // Route for client
                    } else if (isHousekeeper(userEmail)) {
                        navController.navigate(ROUTE_HOUSEKEEPER_SCREEN) // Route for housekeeper
                    } else {
                        navController.navigate(ROUTE_LOGIN_SCREEN) // Default route
                    }
                }
            } else {
                Toast.makeText(context, "${task.exception?.message}", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN_SCREEN)
            }
        }
    }

    fun logout() {
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN_SCREEN)
    }

    fun isloggedin(): Boolean {
        return mAuth.currentUser != null
    }

    private fun isClient(email: String): Boolean {
        // Add your domain checking logic for client
        // For example:
        return email.endsWith("@clientdomain.com")
    }

    private fun isHousekeeper(email: String): Boolean {
        // Add your domain checking logic for housekeeper
        // For example:
        return email.endsWith("@housekeeperdomain.com")
    }

}