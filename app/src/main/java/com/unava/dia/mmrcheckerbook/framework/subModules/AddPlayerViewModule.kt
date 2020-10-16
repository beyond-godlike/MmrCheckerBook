package com.unava.dia.mmrcheckerbook.framework.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.mmrcheckerbook.ui.addPlayer.AddPlayerViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class AddPlayerViewModule {
    @Binds
    abstract fun bindAddPlayerViewModel(viewModel: AddPlayerViewModel): ViewModel
}