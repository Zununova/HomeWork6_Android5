package com.example.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.models.Anime
import com.example.presentation.databinding.ItemBinding

class AnimeAdapter(private val onClick: (id: String) -> Unit) :
    ListAdapter<Anime, AnimeAdapter.AnimeViewHolder>(
        DiffUtilCallback()
    ) {

    inner class AnimeViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Anime) {
            Glide.with(binding.ivImage)
                .load(item.attributes.posterImage?.image)
                .into(binding.ivImage)
            binding.tvItemName.text = item.attributes.titles.title
        }

        init {
            itemView.setOnClickListener {
                val item: Anime = getItem(adapterPosition)
                onClick(item.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<Anime>() {

            override fun areItemsTheSame(
                oldItem: Anime,
                newItem: Anime
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Anime,
                newItem: Anime
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}