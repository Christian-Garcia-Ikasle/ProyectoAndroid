package com.example.proyectoandroid

import android.provider.MediaStore
import androidx.room.*
import kotlinx.coroutines.flow.Flow


class DAO {
    @Dao
    interface VideojuegoDAO {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun Insertar(videojuego: Videojuego)

        @Update
        suspend fun Actualizar(videojuego: Videojuego)

        @Delete
        suspend fun Borrar(videojuego: Videojuego)

        @Query("SELECT * FROM tabla_videojuegos WHERE id like :id")
        fun BuscarPorId(id: Int): Flow<Videojuego>

        @Query("SELECT * FROM tabla_videojuegos ORDER BY id ASC")
        fun MostrarTodas(): Flow<List<Videojuego>>

    }
}