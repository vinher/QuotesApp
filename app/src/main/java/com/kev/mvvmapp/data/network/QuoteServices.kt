package com.kev.mvvmapp.data.network

import com.kev.mvvmapp.core.RetrofitHelper
import com.kev.mvvmapp.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class QuoteServices @Inject constructor(private val api:QuoteApiClient){

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}