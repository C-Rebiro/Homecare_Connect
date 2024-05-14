package com.muthoni.homecare_connect.ui.theme.Screens.Splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.muthoni.homecare_connect.R
import com.muthoni.homecare_connect.navigation.ROUTE_LOGIN_SCREEN
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(durationMillis = 200,
                easing = { OvershootInterpolator(4f).getInterpolation(it) })
        )
        delay(2000L)
        navController.navigate(ROUTE_LOGIN_SCREEN)

    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.homeimage), contentDescription = "Splash",
            modifier = Modifier
                .scale(scale.value)
                .fillMaxSize()
        )
    }
}