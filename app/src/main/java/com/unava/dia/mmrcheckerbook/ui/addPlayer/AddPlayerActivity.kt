package com.unava.dia.mmrcheckerbook.ui.addPlayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.unava.dia.mmrcheckerbook.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class AddPlayerActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: AddPlayerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)
        AndroidInjection.inject(this)
        this.bindViewModel()
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(AddPlayerViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {}
}
