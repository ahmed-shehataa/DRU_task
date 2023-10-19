package com.ashehata.dru.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ashehata.dru.features.movies.data.local.dao.MoviesDao
import com.ashehata.dru.features.movies.data.model.MovieDataModel

@Database(entities = [MovieDataModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}