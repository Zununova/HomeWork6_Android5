package com.example.homework4_android5.domain.usecase

import com.example.homework4_android5.domain.repositores.AnimeRepository
import javax.inject.Inject

class FetchAnimeByIdUseCase @Inject constructor(private val repository: AnimeRepository) {

    operator fun invoke(id: Int) = repository.fetchAnimeById(id)
}