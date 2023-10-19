package com.ashehata.dru.features.movies.data.retrofit.response


import androidx.annotation.Keep
import com.ashehata.dru.features.movies.data.model.MovieDataModel
import com.squareup.moshi.Json

@Keep
data class MoviesResponse(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val movies: List<MovieDataModel>?,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
)
