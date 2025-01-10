package com.ag.projects.sebha.data.respository

import com.ag.projects.sebha.data.local.AzkarDatabase
import com.ag.projects.sebha.data.local.AzkarEntity
import com.ag.projects.sebha.domain.respository.AzkarRepository

class AzkarRepositoryImpl(
    private val azkarDatabase: AzkarDatabase
) : AzkarRepository {

    override suspend fun insertAzkar(azkar: AzkarEntity) =
        azkarDatabase.azkarDao().insertAzkar(azkar)


    override suspend fun getAzkar(): List<AzkarEntity> =
        azkarDatabase.azkarDao().getAzkar()

    override suspend fun incrementAzkarCount(id: Int) {
        azkarDatabase.azkarDao().incrementAzkarCount(id)
    }

    override suspend fun deleteAzkar(id: Int) =
        azkarDatabase.azkarDao().deleteAzkar(id)
}