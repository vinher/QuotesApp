package com.kev.mvvmapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


import com.kev.mvvmapp.data.model.QuoteModel
import com.kev.mvvmapp.domain.GetQuotesUseCase
import com.kev.mvvmapp.domain.GetRandomQuoteUseCase
import com.kev.mvvmapp.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase : GetRandomQuoteUseCase
): ViewModel() {
 val quoteModel = MutableLiveData<Quote>()
 val isLoading = MutableLiveData<Boolean>()


    fun onCreate() {
       viewModelScope.launch {
           isLoading.postValue(true)
           val result = getQuotesUseCase()
           if(!result.isNullOrEmpty()){
               quoteModel.postValue(result[0])
               isLoading.postValue(false)
           }
       }
    }


    fun randomQuote(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            quote?.let {
                quoteModel.value = it
            }
            isLoading.postValue(false)

        }
    }



}