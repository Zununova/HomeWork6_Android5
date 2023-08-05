package com.example.homework4_android5.presentation.ui.fragments.detail

import com.example.homework4_android5.base.BaseViewModel
import com.example.homework4_android5.domain.models.models.DataModel
import com.example.homework4_android5.domain.usecase.FetchAnimeByIdUseCase
import com.example.homework4_android5.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailAnimeViewModel @Inject constructor(private val fetchAnimeByIdUseCase: FetchAnimeByIdUseCase) :
    BaseViewModel() {

    private var _animeStates = MutableStateFlow<UIState<DataModel>>(UIState.Loading())
    val animeStates = _animeStates.asStateFlow()

    fun fetchAnimeById(id: Int) {
        fetchData(
            fetchData = { fetchAnimeByIdUseCase(id)},
            dataState = _animeStates
        )
    }
}