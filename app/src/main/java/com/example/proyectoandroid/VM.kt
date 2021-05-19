package com.example.proyectoandroid

import android.provider.MediaStore
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class VM(private val miRepositorio: Repositorio): ViewModel(){

   val allPeliculas: LiveData<List<Videojuego>> = miRepositorio.listaPeliculas.asLiveData()
    lateinit var miVideojuego:LiveData<Videojuego>

    fun Insertar(miVideojuego: Videojuego) = viewModelScope.launch{
        miRepositorio.Insertar(miVideojuego)
    }

    fun BuscarPorId (id:Int) = viewModelScope.launch {
        miVideojuego = miRepositorio.BuscarPorId(id).asLiveData()
    }

    fun Borrar(miVideojuego: Videojuego) = viewModelScope.launch {
        miRepositorio.Borrar(miVideojuego)
    }

    fun Actualizar(miVideojuego: Videojuego) =viewModelScope.launch {
        miRepositorio.Actualizar(miVideojuego)
    }

    class PeliculaViewModelFactory(private val repository: Repositorio) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(VM::class.java)){
                @Suppress("UNCHECKED_CAST")
                return VM(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }
}