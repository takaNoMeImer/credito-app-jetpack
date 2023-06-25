package com.example.credito_app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.credito_app.ui.utils.FullNameEditText
import com.example.credito_app.ui.utils.HaveDontAcccount
import com.example.credito_app.ui.utils.LoginRegisterImage
import com.example.credito_app.ui.utils.PasswordEditText
import com.example.credito_app.ui.utils.UsernameEditText

@Composable
fun RegisterScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    )
    {
        Register(Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun Register(modifier: Modifier, navController: NavController) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        LoginRegisterImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        FullNameEditText(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        UsernameEditText(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        PasswordEditText(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        RegisterButton(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        HaveDontAcccount(Modifier.align(Alignment.CenterHorizontally), "Ya tienes una cuenta?")
        Spacer(modifier = Modifier.padding(12.dp))
        LoginAccountButton(Modifier.align(Alignment.CenterHorizontally), navController)
    }
}

@Composable
fun RegisterButton(modifier: Modifier) {
    Button(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 12.dp)
    ) {
        Text(text = "REGISTER", color = Color.White)
    }
}

@Composable
fun LoginAccountButton(modifier: Modifier, navController: NavController) {
    Button(
        onClick = { navController.navigate("LoginScreen") },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        border = BorderStroke(1.dp, Color.Blue),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue)
    ) {
        Text(text = "CREAR CUENTA")
    }
}