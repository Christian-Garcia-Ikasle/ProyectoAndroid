package com.example.ejercicio14

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.Adaptador
import com.example.proyectoandroid.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class SecondFragment : Fragment() {


    //val miViewModel:VM by viewModels()
    lateinit var miRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView= inflater.inflate(R.layout.fragment_second, container, false)

        miRecyclerView=rootView.findViewById(R.id.frag2_recyclerView)
        miRecyclerView.layoutManager= LinearLayoutManager(activity)

        (activity as MainActivity).miViewModel.allPeliculas.observe(activity as MainActivity, Observer { Pelicula ->
            Pelicula?.let {
                miRecyclerView.adapter= Adaptador(it, activity as MainActivity)
            }
        })

        return rootView


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FloatingActionButton>(R.id.anyadir).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment)
        }
    }




}