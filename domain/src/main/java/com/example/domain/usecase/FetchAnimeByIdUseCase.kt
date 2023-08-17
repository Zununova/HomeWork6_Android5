package com.example.domain.usecase

import com.example.domain.repositories.AnimeRepository
import javax.inject.Inject

class FetchAnimeByIdUseCase @Inject constructor(private val repository: AnimeRepository) {

    operator fun invoke(id: Int) = repository.fetchAnimeById(id)
}