package com.example.proyectoandroid

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_videojuegos")
data class Videojuego(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @NonNull @ColumnInfo(name = "titulo") val titulo: String,
    @NonNull @ColumnInfo(name = "valoracion") val valoracion: String,
    @NonNull @ColumnInfo(name = "nota") val nota: Int
){}