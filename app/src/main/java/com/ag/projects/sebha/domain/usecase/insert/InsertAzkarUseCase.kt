package com.ag.projects.sebha.domain.usecase.insert

import com.ag.projects.sebha.data.local.AzkarEntity
import com.ag.projects.sebha.domain.respository.AzkarRepository

class InsertAzkarUseCase(
    private val azkarRepository: AzkarRepository
) {

    suspend fun insertAzkar(azkar: AzkarEntity) = azkarRepository.insertAzkar(azkar)
}