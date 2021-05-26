package com.example.proyectoandroid

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class Adaptador(var listaVideojuegos:List<Videojuego>, val actividad: Activity):RecyclerView.Adapter<Adaptador.ViewHolder>() {
    inner class ViewHolder (v: View):RecyclerView.ViewHolder(v){
        var tvTitulo: TextView
        var Nota:TextView
        var posicion:Int = 0
        init{
            tvTitulo=v.findViewById(R.id.item_tvTitulo)
            Nota = v.findViewById(R.id.item_tvNota)
            v.setOnClickListener{
                val bundle= bundleOf("id" to this.posicion)
                actividad.findNavController(R.id.nav_host_fragment).navigate(R.id.action_SecondFragment_to_thirdFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitulo.text=listaVideojuegos[position].titulo
        holder.Nota.text=listaVideojuegos[position].nota.toString()
        holder.posicion = listaVideojuegos[position].id
    }

    override fun getItemCount(): Int {
        return listaVideojuegos.count()
    }

}