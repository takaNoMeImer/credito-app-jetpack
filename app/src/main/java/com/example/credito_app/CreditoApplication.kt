package com.example.credito_app

import android.app.Application
import androidx.room.Room
import com.example.credito_app.data.local.database.AppDatabase

class CreditoApplication : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "my-database"
        ).build()
    }
}

/*import android.app.Application

class CreditoApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}*/