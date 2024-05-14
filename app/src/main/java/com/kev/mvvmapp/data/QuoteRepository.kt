package com.kev.mvvmapp.data

import com.kev.mvvmapp.data.database.dao.QuoteDao
import com.kev.mvvmapp.data.database.entities.QuoteEntity
import com.kev.mvvmapp.data.model.QuoteModel
import com.kev.mvvmapp.data.network.QuoteServices
import com.kev.mvvmapp.domain.model.Quote
import com.kev.mvvmapp.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api:QuoteServices,
    private val quoteDao: QuoteDao
    ){
    suspend fun getAllQuotesFromApi():List<Quote>{
        val response:List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }
    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun InsertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }
    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}