package com.example.androidlab2.adapter


import androidx.recyclerview.widget.DiffUtil
import com.example.androidlab2.model.Cat

class CatDiffUtil : DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem == newItem
    }
}
