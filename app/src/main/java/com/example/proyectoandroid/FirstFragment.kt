package com.example.proyectoandroid

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FirstFragment : Fragment() {

    lateinit var miRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView= inflater.inflate(R.layout.fragment_first, container, false)

        miRecyclerView=rootView.findViewById(R.id.frag1_recyclerView)
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
            findNavController().navigate(R.id.action_FirstFragment_to_thirdFragment)
        }

        setHasOptionsMenu(true)
        activity?.setTitle("Mi top 5")
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_top5)?.isVisible=true
        menu.findItem(R.id.action_lista)?.isVisible=true
    }





    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_top5->true
            R.id.action_lista-> findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

}