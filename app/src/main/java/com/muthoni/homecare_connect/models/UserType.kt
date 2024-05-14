package com.muthoni.homecare_connect.models

sealed class UserType {
    object Client : UserType()
    object Housekeeper : UserType()
}
