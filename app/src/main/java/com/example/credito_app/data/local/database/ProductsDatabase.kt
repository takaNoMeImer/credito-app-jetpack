package com.example.credito_app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.credito_app.data.local.dao.ProductDao
import com.example.credito_app.data.model.Producto

@Database(entities = [Producto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}










/*import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.credito_app.data.local.dao.ProductDao
import com.example.credito_app.data.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductsDatabase:RoomDatabase() {
    abstract fun productsDao():ProductDao

    companion object {
        @Volatile
        var INSTANCE: ProductsDatabase? = null
        fun getDatabase(context:Context):ProductsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ProductsDatabase::class.java,
                    "products_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}*/