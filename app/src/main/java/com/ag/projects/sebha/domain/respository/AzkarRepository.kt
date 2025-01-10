package com.ag.projects.sebha.domain.respository

import com.ag.projects.sebha.data.local.AzkarEntity

interface AzkarRepository {

    suspend fun insertAzkar(azkar: AzkarEntity)

    suspend fun getAzkar(): List<AzkarEntity>

    suspend fun incrementAzkarCount(id: Int)

    suspend fun deleteAzkar(id: Int)
}