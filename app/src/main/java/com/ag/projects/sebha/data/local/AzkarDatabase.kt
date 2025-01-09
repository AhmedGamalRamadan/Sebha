package com.ag.projects.sebha.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AzkarEntity::class],
    version = 1
)
abstract class AzkarDatabase : RoomDatabase() {

    abstract fun azkarDao(): AzkarDao
}