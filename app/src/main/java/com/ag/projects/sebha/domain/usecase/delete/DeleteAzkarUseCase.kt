package com.ag.projects.sebha.domain.usecase.delete

import com.ag.projects.sebha.domain.respository.AzkarRepository

class DeleteAzkarUseCase(
    private val azkarRepository: AzkarRepository
) {
    suspend fun deleteAzkar(id: Int) = azkarRepository.deleteAzkar(id)
}