package com.example.rickandmortyapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.base.BaseDiffUtilItemCallback
import com.example.rickandmortyapi.databinding.ItemRickAndMortyBinding
import com.example.rickandmortyapi.extension.setImage
import com.example.rickandmortyapi.models.RickAndMortyModel

class RickAndMortyAdapter :
    ListAdapter<RickAndMortyModel, RickAndMortyAdapter.HomeViewHolder>(BaseDiffUtilItemCallback()) {

    class HomeViewHolder(private var binding: ItemRickAndMortyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: RickAndMortyModel) {
            binding.itemDimension.text = item.location.dimension
            binding.itemNameCharacter.text = item.character.name
            binding.itemTypeLocation.text = item.location.type
            binding.itemImage.setImage(item.character.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemRickAndMortyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}
