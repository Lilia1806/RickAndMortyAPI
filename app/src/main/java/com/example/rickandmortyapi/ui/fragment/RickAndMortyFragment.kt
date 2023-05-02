package com.example.rickandmortyapi.ui.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.base.BaseFragment
import com.example.rickandmortyapi.databinding.FragmentRickAndMortyBinding
import com.example.rickandmortyapi.ui.adapter.RickAndMortyAdapter
import com.example.rickandmortyapi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RickAndMortyFragment :
    BaseFragment<FragmentRickAndMortyBinding, RickAndMortyViewModel>(R.layout.fragment_rick_and_morty) {

    override val binding by viewBinding(FragmentRickAndMortyBinding::bind)
    override val viewModel: RickAndMortyViewModel by viewModels()
    private val adapter = RickAndMortyAdapter()

    override fun initialize() {
        binding.rvRickAndMorty.adapter = adapter
    }

    override fun setupSubscribes() {
        subscribeToGetData()
    }

    private fun subscribeToGetData() {
        viewModel.noteLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    adapter.submitList(it.data)
                }
            }
        }
    }
}