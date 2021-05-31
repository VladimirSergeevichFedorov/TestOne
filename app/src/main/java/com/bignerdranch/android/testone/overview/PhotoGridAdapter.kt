package com.bignerdranch.android.testone.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.testone.databinding.GridViewItemBinding
import com.bignerdranch.android.testone.network.UseData
//import com.bignerdranch.android.testone.room.Test


class PhotoGridAdapter :
    ListAdapter<UseData, PhotoGridAdapter.TestOneViewHolder>(DiffCallback) {

    class TestOneViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(avatarsUser: UseData) {
            binding.photo = avatarsUser

//            binding.firstnames = avatarsUser
//            binding.lastnames = avatarsUser
            // Это важно, потому что это приводит к немедленному выполнению привязки данных,
            // что позволяет RecyclerView производить правильные измерения размера представления
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<UseData>() {
        override fun areItemsTheSame(oldItem: UseData, newItem: UseData): Boolean =
             oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: UseData, newItem: UseData) = oldItem == newItem
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TestOneViewHolder {
        return TestOneViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }
    override fun onBindViewHolder(holder: TestOneViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}




