package com.example.androidlab2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.androidlab2.databinding.ItemCatBinding
import com.example.androidlab2.model.Cat


class CatAdapter : ListAdapter<Cat, CatAdapter.ViewHolder>(CatDiffUtil()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemCatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context

        fun bind(cat: Cat) {
            binding.name.text = "Name: ${cat.name}"
            binding.origin.text = "Origin: ${cat.origin}"
            binding.minLifeexpectancy.text = "Minimal Life Expentancy: ${cat.minLifeExpectancy.toString()}"
            binding.minWeight.text = "Minimal Weight: ${cat.minWeight.toString()}"
            binding.otherPetsFriendly.text = "Other pets friendly: ${cat.otherPetsFriendly.toString()}"
            binding.playfulness.text = "Playfulness: ${cat.playfulness.toString()}"
            binding.health.text = "General Health: ${cat.health.toString()}"
            val imageUrl = cat.imageLink
            Glide.with(context).load(imageUrl).apply(RequestOptions().transform(RoundedCorners(12))) .into(binding.catImage)


        }
    }
}