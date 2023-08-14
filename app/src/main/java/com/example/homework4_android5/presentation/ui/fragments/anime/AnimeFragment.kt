package com.example.homework4_android5.presentation.ui.fragments.anime

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework4_android5.R
import com.example.homework4_android5.base.BaseFragment
import com.example.homework4_android5.databinding.FragmentAnimeBinding
import com.example.homework4_android5.presentation.state.UIState
import com.example.homework4_android5.presentation.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter(this::onClick)

    private fun onClick(id: String) {

        findNavController().navigate(
            AnimeFragmentDirections.actionAnimeFragmentToDetailAnimeFragment(
                id
            )
        )
    }

    override fun initialize() {
        binding.recyclerViewAnime.apply {
            adapter = animeAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    override fun setupSubscribes() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.animeState.collect {
                    when (it) {
                        is UIState.Error -> Log.e(TAG, it.message)
                        is UIState.Loading -> {
                            binding.pbAnimeFragment.visibility = View.VISIBLE
                            binding.recyclerViewAnime.visibility = View.GONE
                        }

                        is UIState.Success -> {
                            binding.pbAnimeFragment.visibility = View.GONE
                            binding.recyclerViewAnime.visibility = View.VISIBLE
                            animeAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }
}