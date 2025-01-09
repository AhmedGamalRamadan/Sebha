package com.ag.projects.sebha.domain.usecase.get

import com.ag.projects.sebha.data.local.AzkarEntity
import com.ag.projects.sebha.domain.respository.AzkarRepository

class GetAzkarUseCase(
    private val azkarRepository: AzkarRepository

) {
    suspend fun getAzkar(): List<AzkarEntity> = azkarRepository.getAzkar()

}