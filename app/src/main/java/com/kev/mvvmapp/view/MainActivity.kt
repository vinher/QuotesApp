package com.kev.mvvmapp.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.kev.mvvmapp.databinding.ActivityMainBinding
import com.kev.mvvmapp.model.QuoteModel
import com.kev.mvvmapp.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteModels:QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        quoteModels.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAutor.text = it.autor
        })
        binding.viewContainer.setOnClickListener {
            quoteModels.randomQuote()
        }
    }
}