package com.example.proyectoandroid

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.proyectoandroid.BaseDatos
import com.example.proyectoandroid.R
import com.example.proyectoandroid.Repositorio
import com.example.proyectoandroid.VM

class MainActivity : AppCompatActivity() {

    val miViewModel: VM by viewModels {VM.PeliculaViewModelFactory(miRepositorio)}
    val database by lazy { BaseDatos.getDatabase(this)}
    val miRepositorio by lazy { Repositorio(database.miDAO()) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_top5-> true
            R.id.action_lista-> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}