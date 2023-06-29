package com.example.credito_app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.credito_app.ui.services.Data
import com.example.credito_app.ui.services.MyApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ProfileScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    )
    {
        Profile(navController)
    }
}


@Composable
fun Profile(navController: NavController) {

    var data by remember {
        mutableStateOf<List<Data>?>(null)
    }

    /*val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()*/
    val retrofit = Retrofit.Builder()
        .run {
            baseUrl("http://10.0.2.2:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    val apiService = retrofit.create(MyApiService::class.java)

    LaunchedEffect(Unit) {
        try {
            val response = apiService.getData()
            if (response.isSuccessful) {
                data = response.body()
            } else {
                print("Error en la peticion")
            }
        } catch(e: Exception) {
            print("Error en la llamada: $e")
        }
    }

    Column {
        TopBarSetting()
        Spacer(modifier = Modifier.padding(12.dp))
        CardTotalCredit()
        Spacer(modifier = Modifier.padding(12.dp))
        CardsOptions(navController)
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        CreditoList(data)

        //Text(text = "Test")
    }
}

// BARRA SUPERIOR
@Composable
fun TopBarSetting() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Hola, Imer", fontSize = 26.sp)
        Icon(
            imageVector = Icons.Outlined.Settings,
            contentDescription = "Settings",
            Modifier.size(30.dp)
        )
    }
}

// CARD SUPERIOR TOTAL DE CREDITOS
@Composable
fun CardTotalCredit() {
    Card(
        border = BorderStroke(0.dp, Color.LightGray)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(text = "Credito total")
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text(text = "$10,523.59", fontSize = 22.sp)
            }
            Text(text = "Tercer texto")
        }
    }
}

// CARDS DE OPCIONES
@Composable
fun CardsOptions(navController: NavController) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        CardOption(icon = Icons.Outlined.Person, text = "Productos", navController)
        CardOption(icon = Icons.Outlined.Person, text = "Clientes", navController = navController)
        CardOption(icon = Icons.Outlined.Person, text = "Elementos", navController = navController)
        CardOption(icon = Icons.Outlined.Person, text = "Productos", navController = navController)
    }
}

@Composable
fun CardOption(icon: ImageVector, text: String, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            Modifier
                .clip(CircleShape)
                .background(Color.LightGray)
        ) {
            Icon(

                imageVector = icon,
                contentDescription = text,
                Modifier
                    .size(60.dp)
                    .padding(vertical = 16.dp, horizontal = 13.dp)
                    .clickable {
                        navController.navigate("ProductsScreen")
                    }
            )
        }
        Text(text = text)
    }
}

// LISTA DE CREDITOS ACTIVOS
@Composable
fun ListCreditos() {
    Column(Modifier.fillMaxWidth()) {

    }
}


@Composable
fun CreditoItem() {
    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Column() {
            Text(text = "name", fontSize = 18.sp)
            Spacer(modifier = Modifier.padding(vertical = 3.dp))
            Text(text = "date")
        }
        Box() {
            Text(text = "$$120")
        }
    }
}
@Composable
fun CreditoList(creditos: List<Data>?) {

    creditos?.let {data ->
        data.forEach { data ->
            Column {
                Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Column() {
                        Text(text = data.nombre, fontSize = 18.sp)
                        Spacer(modifier = Modifier.padding(vertical = 3.dp))
                        Text(text = "28-06-2023")
                    }
                    Box() {
                        Text(text = "$${data.precio}")
                    }
                }
                Spacer(modifier = Modifier.padding(vertical = 12.dp))
            }
        }
    }



}