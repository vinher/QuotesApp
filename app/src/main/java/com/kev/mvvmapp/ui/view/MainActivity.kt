package com.kev.mvvmapp.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.kev.mvvmapp.databinding.ActivityMainBinding
import com.kev.mvvmapp.data.model.QuoteModel
import com.kev.mvvmapp.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteModels: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        quoteModels.onCreate()

        quoteModels.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAutor.text = it.author
        })
        quoteModels.isLoading.observe(this, Observer{
            binding.progress.isVisible = it
        })
        binding.viewContainer.setOnClickListener {
            quoteModels.randomQuote()
        }
    }
}