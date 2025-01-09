package com.ag.projects.sebha.domain.usecase.increment

import com.ag.projects.sebha.domain.respository.AzkarRepository

class IncrementAzkarCountUseCase(
    private val azkarRepository: AzkarRepository
) {

    suspend fun incrementAzkarCount(id: Int) =
        azkarRepository.incrementAzkarCount(id)

}