package com.example.homework4_android5.presentation.ui.fragments.anime

import androidx.lifecycle.viewModelScope
import com.example.homework4_android5.base.BaseViewModel
import com.example.homework4_android5.domain.Either
import com.example.homework4_android5.domain.models.models.Anime
import com.example.homework4_android5.domain.usecase.FetchAnimeUseCase
import com.example.homework4_android5.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val fetchAnimeUseCase: FetchAnimeUseCase) :
    BaseViewModel() {

    private var _animeState = MutableStateFlow<UIState<List<Anime>>>(UIState.Loading())
    val animeState = _animeState.asStateFlow()

    init {
        fetchAnime()
    }

    private fun fetchAnime() {
        viewModelScope.launch {
            fetchAnimeUseCase().collect {
                when (it) {
                    is Either.Left -> {
                        it.message?.let { message ->
                            _animeState.value = UIState.Error(message)
                        }
                    }
                    is Either.Right -> {
                        it.data?.let { data ->
                            _animeState.value = UIState.Success(data)
                        }
                    }
                }
            }
        }
    }
}