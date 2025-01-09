package com.ag.projects.sebha.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "azkar_table"
)
data class AzkarEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val count: Int,
    val azkar: String
)
