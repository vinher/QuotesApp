package com.kev.mvvmapp.domain

import com.kev.mvvmapp.data.QuoteRepository
import com.kev.mvvmapp.data.database.entities.toDatabase
import com.kev.mvvmapp.data.model.QuoteModel
import com.kev.mvvmapp.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository:QuoteRepository) {

    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()
        return if(quotes.isNotEmpty()){
            //
            repository.clearQuotes()
            repository.InsertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }

}