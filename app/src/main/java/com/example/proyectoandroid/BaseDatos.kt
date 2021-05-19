package com.example.proyectoandroid

import android.content.Context
import android.provider.MediaStore
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Videojuego::class),version = 1,exportSchema = false)
abstract class BaseDatos: RoomDatabase(){
    abstract fun miDAO(): DAO.VideojuegoDAO

    companion object{
        @Volatile
        private var INSTANCE: BaseDatos?=null

        fun getDatabase(context: Context): BaseDatos{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatos::class.java,
                    "videojuego_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}