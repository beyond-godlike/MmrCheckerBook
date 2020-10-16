package com.unava.dia.mmrcheckerbook.framework.viewModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.mmrcheckerbook.ui.addPlayer.AddPlayerViewModel
import com.unava.dia.mmrcheckerbook.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    // factory is singleton
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddPlayerViewModel::class)
    internal abstract fun bindAddPlayerViewModel(viewModel: AddPlayerViewModel): ViewModel

    //Add more ViewModels here
}