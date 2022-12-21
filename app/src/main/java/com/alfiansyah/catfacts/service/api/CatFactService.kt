package com.alfiansyah.catfacts.service.api

import com.alfiansyah.catfacts.model.CatFact
import retrofit2.http.GET

interface CatFactService {
    @GET("fact")
    suspend fun getCatFact(): CatFact
}