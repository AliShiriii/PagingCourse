package com.example.pagingcourse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagingcourse.databinding.RickMortyItemsBinding
import com.example.pagingcourse.models.RickMorty
import com.example.pagingcourse.view.HomeFragmentDirections

class RickMortyAdapter : PagingDataAdapter<RickMorty, RickMortyAdapter.RickViewHolder>(diffCallBack) {

    inner class RickViewHolder(private val binding : RickMortyItemsBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(rickMorty: RickMorty){

            binding.title.text = rickMorty.name
            
            Glide.with(itemView)
                .load(rickMorty.image)
                .into(binding.imageView)

        }

    }

    companion object{

        val diffCallBack = object : DiffUtil.ItemCallback<RickMorty>(){
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean =

                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean =

                oldItem == newItem

        }

    }

    override fun onBindViewHolder(holder: RickViewHolder, position: Int) {

        val currentItem = getItem(position)

        if (currentItem != null){

            holder.bind(currentItem)
        }

        holder.itemView.setOnClickListener {mView ->

            val actions = HomeFragmentDirections.actionRichMortyFragmentToDetailsFragment(currentItem!!)
            mView.findNavController().navigate(actions)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickViewHolder {

        return RickViewHolder(RickMortyItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}