package com.example.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.either.Either
import com.example.presentation.state.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected open fun <T> fetchData(
        fetchData: () -> Flow<Either<String, T>>,
        dataState: MutableStateFlow<UIState<T>>
    ) {
        viewModelScope.launch {
            fetchData().collect {
                when (it) {
                    is Either.Left -> {
                        it.message?.let { message ->
                            dataState.value = UIState.Error(message)
                        }
                    }

                    is Either.Right -> {
                        it.data?.let { data ->
                            dataState.value = UIState.Success(data)
                        }
                    }
                }
            }
        }
    }
}