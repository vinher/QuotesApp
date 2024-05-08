package com.kev.mvvmapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.kev.mvvmapp.QuoteModels
import com.kev.mvvmapp.model.QuoteModel

class QuoteViewModel: ViewModel() {
 val quoteModel = MutableLiveData<QuoteModel>()
    fun randomQuote(){
        val currentQuote = QuoteModels.randomQuote()
        quoteModel.postValue(currentQuote)
    }

}