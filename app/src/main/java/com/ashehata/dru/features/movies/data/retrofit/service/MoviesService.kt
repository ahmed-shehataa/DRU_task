package com.ashehata.dru.features.movies.data.retrofit.service

import com.ashehata.dru.features.movies.data.retrofit.response.MoviesResponse
import retrofit2.http.GET


interface MoviesService {

    @GET("")
    suspend fun getMovies(): MoviesResponse
}