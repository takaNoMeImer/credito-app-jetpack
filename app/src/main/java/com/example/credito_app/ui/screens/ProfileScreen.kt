package com.example.credito_app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Date

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    )
    {
        Profile()
    }
}

@Composable
fun Profile() {
    Column {
        TopBarSetting()
        Spacer(modifier = Modifier.padding(12.dp))
        CardTotalCredit()
        Spacer(modifier = Modifier.padding(12.dp))
        CardsOptions()
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        ListCreditos()
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
fun CardsOptions() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        CardOption(icon = Icons.Outlined.Person, text = "Productos")
        CardOption(icon = Icons.Outlined.Person, text = "Clientes")
        CardOption(icon = Icons.Outlined.Person, text = "Elementos")
        CardOption(icon = Icons.Outlined.Person, text = "Productos")
    }
}

@Composable
fun CardOption(icon: ImageVector, text: String) {
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
            )
        }
        Text(text = text)
    }
}

// LISTA DE CREDITOS ACTIVOS
@Composable
fun ListCreditos() {
    Column(Modifier.fillMaxWidth()) {
        Text("CREDITOS ACTIVOS", Modifier.align(Alignment.CenterHorizontally), fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        Credito("Imer", "01-02-2023", "100")
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Credito("Antonio", "02-02-2023", "200")
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Credito("Gonzalez", "01-02-2023", "60")
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Credito("Herrera", "02-02-2023", "130")
    }
}

@Composable
fun Credito(name: String, date: String, quantity: String) {
    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Column() {
            Text(text = name, fontSize = 18.sp)
            Spacer(modifier = Modifier.padding(vertical = 3.dp))
            Text(text = date)
        }
        Box() {
            Text(text = "$$quantity")
        }
    }
}