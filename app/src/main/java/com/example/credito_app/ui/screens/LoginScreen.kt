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
import androidx.navigation.NavHostController
import com.example.credito_app.ui.utils.HaveDontAcccount
import com.example.credito_app.ui.utils.LoginRegisterImage
import com.example.credito_app.ui.utils.PasswordEditText
import com.example.credito_app.ui.utils.UsernameEditText

@Composable
fun LoginScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    )
    {
        Login(Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun Login(modifier: Modifier, navController: NavController) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        LoginRegisterImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        UsernameEditText(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        PasswordEditText(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        ForgotPassword(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        LoginButton(Modifier.align(Alignment.CenterHorizontally), navController)
        Spacer(modifier = Modifier.padding(12.dp))
        HaveDontAcccount(Modifier.align(Alignment.CenterHorizontally), "No tienes una cuenta?")
        Spacer(modifier = Modifier.padding(12.dp))
        CreateAccountButton(Modifier.align(Alignment.CenterHorizontally), navController)
    }
}

@Composable
fun CreateAccountButton(modifier: Modifier, navController: NavController) {
    Button(
        onClick = { navController.navigate("RegisterScreen") },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        border = BorderStroke(1.dp, Color.Blue),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue)
    ) {
        Text(text = "REGISTRARME")
    }
}

@Composable
fun LoginButton(modifier: Modifier, navController: NavController) {
    Button(
        onClick = {navController.navigate("ProfileScreen")},
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 12.dp)
    ) {
        Text(text = "LOGIN", color = Color.White)
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(text = "Forgot Password?", modifier = modifier, color = Color.Blue)
}