package com.unava.dia.mmrcheckerbook.framework.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.mmrcheckerbook.ui.main.MainViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class MainViewModule {
    @Binds
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}