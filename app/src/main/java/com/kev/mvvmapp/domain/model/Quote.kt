package com.kev.mvvmapp.domain.model

import com.kev.mvvmapp.data.database.entities.QuoteEntity
import com.kev.mvvmapp.data.model.QuoteModel

data class Quote(val quote:String, val author:String)
fun QuoteModel.toDomain() = Quote(quote,author)
fun QuoteEntity.toDomain() = Quote(quote,author)