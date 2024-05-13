package com.muthoni.homecare_connect.ui.theme.Screens.Services



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.muthoni.homecare_connect.data.ServiceViewModel
import com.muthoni.homecare_connect.navigation.ROUTE_UPDATE_SERVICE
import com.muthoni.homecare_connect.models.Upload

@Composable
fun UploadService(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var serviceRepository = ServiceViewModel(navController, context)


        val emptyUploadState = remember { mutableStateOf(Upload("","","","")) }
        var emptyUploadsListState = remember { mutableStateListOf<Upload>() }

        var uploads = serviceRepository.viewUploads(emptyUploadState, emptyUploadsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All uploads",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(uploads){
                    Uploadservice(
                        name = it.name,
                        charge = it.charge,
                        imageUrl = it.imageUrl,
                        id = it.id,
                        navController = navController,
                        serviceRepository = serviceRepository
                    )
                }
            }
        }
    }
}


@Composable
fun Uploadservice(name:String, charge:String, imageUrl:String, id:String,
                  navController:NavHostController, serviceRepository:ServiceViewModel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = charge)
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        Button(onClick = {
            serviceRepository.deleteService(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_SERVICE+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}

@Preview
@Composable
private fun Uploadprev() {
    UploadService(rememberNavController())

}
