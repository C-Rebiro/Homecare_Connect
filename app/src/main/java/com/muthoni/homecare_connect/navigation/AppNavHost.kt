package com.muthoni.homecare_connect.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.muthoni.homecare_connect.ui.theme.Screens.Home.ClientScreen
import com.muthoni.homecare_connect.ui.theme.Screens.Home.HousekeeperScreen
import com.muthoni.homecare_connect.ui.theme.Screens.Login.LoginScreen
import com.muthoni.homecare_connect.ui.theme.Screens.Register.RegisterScreen
import com.muthoni.homecare_connect.ui.theme.Screens.Services.AddService
import com.muthoni.homecare_connect.ui.theme.Screens.Services.UpdateService


@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String = ROUTE_LOGIN_SCREEN) {
    NavHost(navController = navController, modifier = Modifier, startDestination = startDestination) {
        composable(ROUTE_LOGIN_SCREEN){
            LoginScreen(navController)
        }
        composable(ROUTE_HOUSEKEEPER_SCREEN){
            HousekeeperScreen(navController)
        }
        composable(ROUTE_REGISTER_SCREEN){
            RegisterScreen(navController)
        }
        composable(ROUTE_CLIENT_SCREEN){
            ClientScreen(navController)
        }
        composable(ROUTE_ADD_SERVICE){
            AddService(navController)
        }
        composable(ROUTE_UPDATE_SERVICE+ "/{id}"){passedData ->
            UpdateService(navController,passedData.arguments?.getString("id")!!)
        }

    }
}