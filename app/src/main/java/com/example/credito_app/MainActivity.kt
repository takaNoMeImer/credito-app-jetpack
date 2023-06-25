package com.example.credito_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.credito_app.ui.screens.LoginScreen
import com.example.credito_app.ui.screens.ProductsScreen
import com.example.credito_app.ui.screens.RegisterScreen
import com.example.credito_app.ui.screens.StartedScreen
import com.example.credito_app.ui.theme.CREDITO_APPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CREDITO_APPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "StartedScreen") {
                        composable("StartedScreen") {
                            StartedScreen(navController)
                        }
                        composable("LoginScreen") {
                            LoginScreen(navController)
                        }
                        composable("RegisterScreen") {
                            RegisterScreen(navController)
                        }
                        composable("ProductsScreen") {
                            ProductsScreen()
                        }
                    }
                }
            }
        }
    }
}