package com.example.credito_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.credito_app.R

@Composable
fun StartedScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                15.dp
            )
    ) {
        Started(Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun Started(modifier: Modifier, navController: NavHostController) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        StartedImage(Modifier.align(Alignment.CenterHorizontally))
        WelcomeMessage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        SecondaryMessage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        StartedButton(Modifier.align(Alignment.CenterHorizontally), navController)

    }
}

@Composable
fun StartedButton(modifier: Modifier, navController: NavHostController) {
    Button(
        onClick = { navController.navigate("LoginScreen") },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
        Text(text = "GET STARTED")
    }
}

@Composable
fun SecondaryMessage(modifier: Modifier) {
    Text(
        text = "Bienvenido a nuestra aplicacion de creditos!\nEn que te puedo ayudar?",
        modifier = modifier,
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        color = Color(53, 54, 53)
    )
}

@Composable
fun WelcomeMessage(modifier: Modifier) {
    Text(
        text = "WELCOME TO\n CREDITO APP",
        modifier = modifier,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun StartedImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.started),
        contentDescription = "Started Image",
        modifier = modifier
    )
}