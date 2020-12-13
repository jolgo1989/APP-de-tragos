package com.example.appdetragos.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appdetragos.R
import com.example.appdetragos.data.Drink
import javax.xml.transform.dom.DOMResult


class TragosDetallerFragment : Fragment() {

private lateinit var drink: Drink
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable("drink")!!
            Log.d("DETALLES_FRAG","$drink")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tragos_detaller, container, false)
    }


}