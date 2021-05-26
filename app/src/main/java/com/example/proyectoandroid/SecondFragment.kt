package com.example.proyectoandroid

import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import androidx.fragment.app.Fragment
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.Adaptador
import com.example.proyectoandroid.MainActivity
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

        (activity as MainActivity).miViewModel.allVideojuego.observe(activity as MainActivity, Observer { Videojuego ->
            Videojuego?.let {
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
        setHasOptionsMenu(true)
        activity?.setTitle("Lista completa")
    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_top)?.isVisible=true
        menu.findItem(R.id.action_lista)?.isVisible=true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_top->findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            R.id.action_lista-> true
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }



}