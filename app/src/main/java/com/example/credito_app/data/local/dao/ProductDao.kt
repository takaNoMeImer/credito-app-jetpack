package com.example.credito_app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.credito_app.data.model.Producto

@Dao
interface ProductDao {
    @Query("SELECT * FROM productos")
    suspend fun getProductos(): List<Producto>

    @Insert
    suspend fun insertProducto(producto: Producto)
}