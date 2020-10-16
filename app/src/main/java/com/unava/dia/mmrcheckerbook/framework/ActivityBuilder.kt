package com.unava.dia.mmrcheckerbook.framework

import com.unava.dia.mmrcheckerbook.framework.subModules.AddPlayerViewModule
import com.unava.dia.mmrcheckerbook.framework.subModules.MainViewModule
import com.unava.dia.mmrcheckerbook.ui.addPlayer.AddPlayerActivity
import com.unava.dia.mmrcheckerbook.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [
        MainViewModule::class
    ])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [
        AddPlayerViewModule::class
    ])
    internal abstract fun bindAddPlayerActivity(): AddPlayerActivity
}