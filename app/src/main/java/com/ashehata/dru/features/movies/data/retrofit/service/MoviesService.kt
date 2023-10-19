package com.ashehata.dru.features.movies.data.retrofit.service

import com.ashehata.dru.features.movies.data.retrofit.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Headers


interface MoviesService {

    @GET("movie/popular")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYTE1MjI0MzU1NjBmOThlN2Y2MmJmOGZhZDVkMGU1YyIsInN1YiI6IjYzNDZjMGMwZDU1YzNkMDA5MWI2MjU4MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.UGdd_xct65byKUEfXDYX2F3Z7Pw4aypXyRbSQputwH0")
    suspend fun getMovies(): MoviesResponse
}