package com.example.appdetragos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdetragos.R
import com.example.appdetragos.data.DataSource
import com.example.appdetragos.databinding.FragmentMainBinding
import com.example.appdetragos.domain.RepoImpl
import com.example.appdetragos.ui.viewmodel.MainViewModel
import com.example.appdetragos.ui.viewmodel.VMFactory


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

    }

    private fun setupReciclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //metodo para color Dividir al RecyclerView
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }
}