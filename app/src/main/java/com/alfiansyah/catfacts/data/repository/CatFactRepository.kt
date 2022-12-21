package com.alfiansyah.catfacts.data.repository

import com.alfiansyah.catfacts.model.CatFact
import com.alfiansyah.catfacts.service.api.CatFactService

class CatFactRepository(private val catFactService: CatFactService) {
    suspend fun getCatFact(): CatFact = catFactService.getCatFact()

}