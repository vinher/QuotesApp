package com.kev.mvvmapp.domain

import com.kev.mvvmapp.data.QuoteRepository
import com.kev.mvvmapp.data.model.QuoteModel
import com.kev.mvvmapp.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (0 .. quotes.size-1).random()
            return quotes[randomNumber]
        }
        return null
    }
}