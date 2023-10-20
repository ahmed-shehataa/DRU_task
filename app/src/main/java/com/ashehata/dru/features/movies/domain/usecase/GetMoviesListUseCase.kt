package com.ashehata.dru.features.movies.domain.usecase

import com.ashehata.dru.features.movies.domain.model.MovieDomainModel
import com.ashehata.dru.features.movies.domain.repository.MovesRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetMoviesListUseCase @Inject constructor(
    private val repository: MovesRepository
) {

    suspend fun execute(): List<MovieDomainModel> {
        delay(1500)
        return repository.getMovies()
    }
}