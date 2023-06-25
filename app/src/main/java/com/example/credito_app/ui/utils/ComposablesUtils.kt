package com.example.credito_app.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.credito_app.R

@Composable
fun LoginRegisterImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.login_background),
        contentDescription = "ImageLoginRegiste",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordEditText(modifier: Modifier) {

    var text by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = { text = it },
        label = { Text(text = "Password") },
        visualTransformation = PasswordVisualTransformation()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameEditText(modifier: Modifier) {
    var text by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = { text = it },
        label = { Text("Username") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullNameEditText(modifier: Modifier) {
    var text by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = { text = it },
        label = { Text("Full name") }
    )
}

@Composable
fun HaveDontAcccount(modifier: Modifier, message: String) {
    Text(text = message, color = Color.Blue, modifier = modifier)
}