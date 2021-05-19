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
        var tvId:TextView
        var tvTitulo: TextView
        var tvValoracion:TextView
        var Nota:Int
        var posicion:Int = 0
        init{
            tvId=v.findViewById(R.id.item_tvId)
            tvTitulo=v.findViewById(R.id.item_tvTitulo)
            tvValoracion=v.findViewById(R.id.item_tvValoracion)
            Nota = 0
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
        holder.tvId.text=listaVideojuegos[position].id.toString()
        holder.tvTitulo.text=listaVideojuegos[position].titulo
        holder.tvValoracion.text=String.format("Genero: ${listaVideojuegos[position].valoracion}")
        holder.Nota=listaVideojuegos[position].nota
        holder.posicion = listaVideojuegos[position].id
    }

    override fun getItemCount(): Int {
        return listaVideojuegos.count()
    }

}