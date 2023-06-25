package com.example.credito_app.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    )
    {
        Products()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Products() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, containerColor = Color(107, 83, 229)) {
                Icon(Icons.Default.Add, contentDescription = "", tint = Color.White)
            }
        }
    ) {
        Product()
    }
}

@Composable
fun Product() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Imagen")
        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
        Column {
            Text(text = "Libra de Café", fontSize = 20.sp)
            Text(text = "$5 por unidad", fontSize = 18.sp)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    ProductsScreen()
}