package com.example.proyectoandroid

import android.os.strictmode.ResourceMismatchViolation
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class Repositorio (val miDAO: DAO.VideojuegoDAO){
    val listaVideojuegos: Flow<List<Videojuego>> = miDAO.MostrarTodas()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Insertar(miVideojuego: Videojuego){
        miDAO.Insertar(miVideojuego)
    }

    fun BuscarPorId(id:Int): Flow<Videojuego>{
       return miDAO.BuscarPorId(id)
    }

    fun top():Flow<List<Videojuego>>{
        return miDAO.top()
    }

    fun todos():Flow<List<Videojuego>>{
        return miDAO.MostrarTodas()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Borrar(miVideojuego: Videojuego){
        miDAO.Borrar(miVideojuego)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Actualizar(miVideojuego: Videojuego){
        miDAO.Actualizar(miVideojuego)
    }
}