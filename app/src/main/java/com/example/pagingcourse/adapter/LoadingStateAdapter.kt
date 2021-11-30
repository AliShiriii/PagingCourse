package com.example.pagingcourse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingcourse.databinding.ErrorStateBinding

class LoadingStateAdapter constructor(private val retry: () -> Unit) :
    LoadStateAdapter<LoadingStateAdapter.LoadStateViewHolder>() {


    class LoadStateViewHolder(private val binding: ErrorStateBinding, retry: () -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

            init {

                binding.btnRetry.setOnClickListener {

                    retry()

                }
            }

        fun bind(loadState: LoadState){

            binding.apply {

                progressBar.isVisible = loadState is LoadState.Loading
                btnRetry.isVisible = loadState !is LoadState.Loading
                txtError.isVisible = loadState !is LoadState.Error

            }

        }

    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {

        holder.bind(loadState)

    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {

        return LoadStateViewHolder(ErrorStateBinding.inflate(LayoutInflater.from(
            parent.context), parent, false), retry)
    }
}