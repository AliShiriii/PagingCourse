package com.example.pagingcourse.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pagingcourse.R
import com.example.pagingcourse.adapter.RickMortyAdapter
import com.example.pagingcourse.databinding.FragmentHomeBinding
import com.example.pagingcourse.viewModel.RickMortyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RickMortyViewModel by viewModels()

    private lateinit var rickAdapter: RickMortyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        loadingData()

    }


    private fun setUpRecyclerView() {

        rickAdapter = RickMortyAdapter()

        binding.recyclerView.apply {

            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = rickAdapter

            setHasFixedSize(true)

        }

    }


    private fun loadingData() {

        lifecycleScope.launch {
            viewModel.rickMortyData.collect { pagingData->

                rickAdapter.submitData(pagingData)

            }
        }

    }


}