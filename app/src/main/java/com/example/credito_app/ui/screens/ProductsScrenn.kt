package com.example.credito_app.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.credito_app.ui.viewmodel.ProductsViewModel

@Composable
fun ProductsScreen(productoModel: ProductsViewModel = viewModel()) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    )
    {
        Products(productoModel)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Products(productoModel: ProductsViewModel) {
    val productosState by remember {
        productoModel.productos
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { productoModel.mostrarDialogoAgregar.value = true },
                containerColor = Color(107, 83, 229)
            ) {
                Icon(Icons.Default.Add, contentDescription = "", tint = Color.White)
            }
        }
    ) {
        Column {
            Button(onClick = {
                productoModel.obtenerProductos()
            }) {
                Text("Obtener Productos")
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            productosState.forEach { producto ->
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Imagen")
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Column {
                        Text(text = producto.nombre, fontSize = 20.sp)
                        Text(text = producto.precio.toString(), fontSize = 18.sp)
                    }
                }
            }

            if (productoModel.mostrarDialogoAgregar.value) {
                if (productoModel.mostrarDialogoAgregar.value) {

                    // Campos para ingresar los datos del nuevo producto
                    var nombreProducto by remember { mutableStateOf("") }
                    var precioProducto by remember { mutableStateOf("") }

                    AlertDialog(

                        onDismissRequest = {
                            productoModel.mostrarDialogoAgregar.value = false
                        },
                        title = {
                            Text(text = "Agregar Producto")
                        },
                        text = {

                            Column {
                                OutlinedTextField(
                                    value = nombreProducto,
                                    onValueChange = { nombreProducto = it },
                                    label = { Text("Nombre del producto") }
                                )

                                OutlinedTextField(
                                    value = precioProducto,
                                    onValueChange = { precioProducto = it },
                                    label = { Text("Precio del producto") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                                )
                            }

                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    val nombre = nombreProducto
                                    val precio = precioProducto.toDoubleOrNull()

                                    if (nombre != null && precio != null) {
                                        productoModel.guardarProducto(nombre, precio)
                                    }

                                    productoModel.mostrarDialogoAgregar.value = false
                                }
                            ) {
                                Text(text = "Guardar")
                            }
                        },
                        dismissButton = {
                            Button(
                                onClick = {
                                    productoModel.mostrarDialogoAgregar.value = false
                                }
                            ) {
                                Text(text = "Cancelar")
                            }
                        }
                    )
                }
            }
        }
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