package com.ashehata.dru.features.movies.data.local.dao

import androidx.room.*
import com.ashehata.dru.features.movies.data.model.MovieDataModel

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies")
    suspend fun getMovies(): List<MovieDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(drugs: List<MovieDataModel>)

    @Query("DELETE FROM movies")
    suspend fun deleteAll()

}