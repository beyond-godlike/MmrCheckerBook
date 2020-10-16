package com.unava.dia.mmrcheckerbook.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.unava.dia.mmrcheckerbook.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        this.bindViewModel()
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {}
}
