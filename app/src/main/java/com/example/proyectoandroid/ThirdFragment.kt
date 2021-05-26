package com.example.proyectoandroid

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.proyectoandroid.MainActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ThirdFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titulo:EditText = view.findViewById(R.id.frag3_Titulo)
        val valoracion:EditText = view.findViewById(R.id.frag3_Valoracion)
        val nota:EditText = view.findViewById(R.id.frag3_nota)

        var miVideojuego = Videojuego(titulo = "",valoracion = "",nota = 0)

        val id:Int=arguments?.getInt("id") ?:-1

        if (id == -1) {
            view.findViewById<Button>(R.id.frag3_modificar).isInvisible = true
            view.findViewById<Button>(R.id.frag3_borrar).isInvisible = true
            view.findViewById<Button>(R.id.frag3_insertar).isVisible = true
        }
        else{

            (activity as MainActivity).miViewModel.BuscarPorId(id)
            (activity as MainActivity).miViewModel.miVideojuego.observe(activity as MainActivity){
                it?.let{
                miVideojuego = it
                view.findViewById<EditText>(R.id.frag3_Titulo).setText(it.titulo)
                view.findViewById<EditText>(R.id.frag3_Valoracion).setText(it.valoracion)
                view.findViewById<EditText>(R.id.frag3_nota).setText(it.nota.toString())
                }
            }


            view.findViewById<Button>(R.id.frag3_modificar).isVisible = true
            view.findViewById<Button>(R.id.frag3_borrar).isVisible = true
            view.findViewById<Button>(R.id.frag3_insertar).isInvisible = true
        }

        view.findViewById<Button>(R.id.frag3_modificar).setOnClickListener{
            if (titulo.text == null || valoracion.text == null || nota.text == null){
                findNavController().navigate(R.id.action_thirdFragment_to_SecondFragment)
            }
            else{
                (activity as MainActivity).miViewModel.Actualizar(Videojuego(id = id,titulo = titulo.text.toString(),valoracion = valoracion.text.toString(),nota = nota.text.toString().toInt()))
            }

            findNavController().navigate(R.id.action_thirdFragment_to_SecondFragment)

        }

        view.findViewById<Button>(R.id.frag3_borrar).setOnClickListener{

            (activity as MainActivity).miViewModel.Borrar(miVideojuego)

            findNavController().navigate(R.id.action_thirdFragment_to_SecondFragment)

        }

        view.findViewById<Button>(R.id.frag3_insertar).setOnClickListener{
            if (titulo.text == null || valoracion.text == null || nota.text == null){
                findNavController().navigate(R.id.action_thirdFragment_to_SecondFragment)
            }
            else{
                (activity as MainActivity).miViewModel.Insertar(Videojuego(titulo = titulo.text.toString(),valoracion = valoracion.text.toString(),nota = nota.text.toString().toInt()) )
            }
            findNavController().navigate(R.id.action_thirdFragment_to_SecondFragment)

        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_top->findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            R.id.action_lista-> findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

}

