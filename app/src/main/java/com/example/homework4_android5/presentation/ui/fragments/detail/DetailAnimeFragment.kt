package com.example.homework4_android5.presentation.ui.fragments.detail

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.homework4_android5.R
import com.example.homework4_android5.base.BaseFragment
import com.example.homework4_android5.databinding.FragmentDetailAnimeBinding
import com.example.homework4_android5.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailAnimeFragment :
    BaseFragment<FragmentDetailAnimeBinding, DetailAnimeViewModel>(R.layout.fragment_detail_anime) {

    override val binding by viewBinding(FragmentDetailAnimeBinding::bind)
    override val viewModel by viewModels<DetailAnimeViewModel>()
    private val args by navArgs<DetailAnimeFragmentArgs>()

    override fun initialize() {
        viewModel.fetchAnimeById(args.numberId.toInt())
    }

    override fun setupSubscribes() {
        lifecycleScope.launch {
            viewModel.animeStates.collect {
                when (it) {
                    is UIState.Error -> binding.tvName.text = it.message
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