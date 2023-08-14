package com.example.presentation.ui.fragments.detail

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentDetailAnimeBinding
import com.example.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailAnimeFragment :
    BaseFragment<FragmentDetailAnimeBinding, DetailAnimeViewModel>(R.layout.fragment_detail_anime) {

    override val binding by viewBinding(FragmentDetailAnimeBinding::bind)
    override val viewModel by viewModels<DetailAnimeViewModel>()
    private val args by navArgs<DetailAnimeFragmentArgs>()

    override fun setupSubscribes() {
        loadAnimeDetail()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.animeStates.collect {
                    when (it) {
                        is UIState.Error -> Toast.makeText(
                            requireContext(),
                            it.message,
                            Toast.LENGTH_SHORT
                        ).show()

                        is UIState.Loading -> {
                            binding.pbDetailAnimeFragment.visibility = View.VISIBLE
                            binding.llDetailAnimeFragment.visibility = View.GONE
                        }

                        is UIState.Success -> {
                            binding.pbDetailAnimeFragment.visibility = View.GONE
                            binding.llDetailAnimeFragment.visibility = View.VISIBLE
                            Glide.with(binding.ivPoster)
                                .load(it.data.anime.attributes.posterImage?.image)
                                .into(binding.ivPoster)
                            binding.tvDetailText.text = it.data.anime.attributes.detail
                            binding.tvName.text = it.data.anime.attributes.titles.title
                        }
                    }
                }
            }
        }
    }

    private fun loadAnimeDetail() {
        viewModel.fetchAnimeById(args.numberId.toInt())
    }
}