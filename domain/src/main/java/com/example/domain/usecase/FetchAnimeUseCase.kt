package com.example.domain.usecase

import com.example.domain.repositores.AnimeRepository
import javax.inject.Inject

class FetchAnimeUseCase @Inject constructor(private val repository: AnimeRepository) {

    operator fun invoke() = repository.fetchAnime()
}