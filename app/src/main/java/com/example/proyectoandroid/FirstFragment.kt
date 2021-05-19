package com.example.proyectoandroid

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        activity?.setTitle("Juegos")
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_top5)?.isVisible=true
        menu.findItem(R.id.action_lista)?.isVisible=true
    }





    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_top5->true
            R.id.action_lista-> findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            else -> super.onOptionsItemSelected(item)
        }
    }

}