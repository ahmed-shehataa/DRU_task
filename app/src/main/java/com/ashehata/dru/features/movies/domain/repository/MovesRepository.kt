package com.ashehata.dru.features.movies.domain.repository

import com.ashehata.dru.features.movies.domain.model.MovieDomainModel

interface MovesRepository {

    suspend fun getMovies(): List<MovieDomainModel>
}