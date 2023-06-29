package com.example.credito_app.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.credito_app.CreditoApplication
import com.example.credito_app.data.model.Producto
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {
    private val productoDao = CreditoApplication.database.productDao()
    val productos = mutableStateOf<List<Producto>>(emptyList())
    val mostrarDialogoAgregar = mutableStateOf(false)

    fun obtenerProductos() {
        viewModelScope.launch {
            val listaProductos = productoDao.getProductos()
            productos.value = listaProductos
        }
    }

    fun guardarProducto(nombre: String, precio: Double) {
        viewModelScope.launch {
            val producto = Producto(nombre = nombre, precio = precio)
            productoDao.insertProducto(producto)
        }
    }
}