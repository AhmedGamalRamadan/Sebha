package com.ag.projects.sebha.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface AzkarDao {

    @Upsert
    suspend fun insertAzkar(azkar: AzkarEntity)

    @Query("SELECT * FROM azkar_table")
    suspend fun getAzkar(): List<AzkarEntity>

    @Query("UPDATE azkar_table SET count = count + 1 WHERE id = :id")
    suspend fun incrementAzkarCount(id: Int)
}