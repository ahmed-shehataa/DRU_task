package com.ashehata.dru.database.room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase

@Database(entities = [DrugDataModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun diabetesDao(): DiabetesDao
}


@Entity
data class DrugDataModel(
    var asds: Int
)

@Dao
interface DiabetesDao