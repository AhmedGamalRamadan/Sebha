package com.ag.projects.sebha.domain.usecase.reset

import com.ag.projects.sebha.domain.respository.AzkarRepository

class ResetAzkarToZeroUseCase(
    private val azkarRespository: AzkarRepository
) {

    suspend fun resetAzkarToZero(id: Int) = azkarRespository.resetAzkarToZero(id)
}