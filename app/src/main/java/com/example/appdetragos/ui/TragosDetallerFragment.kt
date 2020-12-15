package com.example.appdetragos.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.appdetragos.R
import com.example.appdetragos.data.Drink
import com.example.appdetragos.databinding.FragmentMainBinding
import com.example.appdetragos.databinding.FragmentTragosDetallerBinding
import com.example.appdetragos.databinding.TragosRowBinding
import kotlinx.android.synthetic.main.fragment_tragos_detaller.*
import javax.xml.transform.dom.DOMResult


class TragosDetallerFragment : Fragment() {

    private lateinit var binding: FragmentTragosDetallerBinding

    private lateinit var drink: Drink
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable("drink")!!
            Log.d("DETALLES_FRAG", "$drink")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tragos_detaller, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTragosDetallerBinding.bind(view)
        Glide.with(requireContext()).load(drink.imgen).into(binding.imgTragos2)
        binding.tragosTittle.text = drink.nombre
        binding.tragoDesc.text = drink.descripcion

    }


}