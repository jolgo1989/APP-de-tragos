package com.example.appdetragos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.engine.Resource
import com.example.appdetragos.R
import com.example.appdetragos.data.DataSource
import com.example.appdetragos.databinding.FragmentMainBinding
import com.example.appdetragos.domain.RepoImpl
import com.example.appdetragos.ui.viewmodel.MainAdapter
import com.example.appdetragos.ui.viewmodel.MainViewModel
import com.example.appdetragos.ui.viewmodel.VMFactory
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource())) }

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)
        setupReciclerView()
        viewModel.fetchTragosList.observe(viewLifecycleOwner, Observer { result ->

            when (result) {
                is com.example.appdetragos.vo.Resource.Loading -> {
                    //Metodo para el progresasBar(Loading)
                    progressBar.visibility = View.VISIBLE
                }
                is com.example.appdetragos.vo.Resource.Success -> {
                    progressBar.visibility = View.GONE
                    recyclerView.adapter = MainAdapter(requireContext(),result.data)
                }
                is com.example.appdetragos.vo.Resource.Failure -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrio un erro al traer los datos${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }

        })

    }

    private fun setupReciclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //metodo para color Divider al RecyclerView
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }
}