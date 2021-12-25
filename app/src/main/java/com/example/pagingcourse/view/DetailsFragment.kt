package com.example.pagingcourse.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pagingcourse.R
import com.example.pagingcourse.databinding.FragmentDettailsBinding
import com.example.pagingcourse.model.RickMorty
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_dettails) {

    private var _binding : FragmentDettailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var rickMorty: RickMorty

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentDettailsBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rickMorty = args.recipe

        populateUi()

    }

    private fun populateUi(){

        binding.apply {

            titleDetail.text = rickMorty.name
            Glide.with(requireActivity())
                .load(rickMorty.image)
                .into(imageViewDetail)

        }
    }

}