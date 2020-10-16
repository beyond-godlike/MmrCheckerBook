package com.unava.dia.mmrcheckerbook.framework

import android.app.Application
import com.unava.dia.mmrcheckerbook.MmrCheckerBookApp
import com.unava.dia.mmrcheckerbook.framework.network.NetworkModule
import com.unava.dia.mmrcheckerbook.framework.useCases.UseCasesModule
import com.unava.dia.mmrcheckerbook.framework.viewModule.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class,
    ViewModelModule::class,
    NetworkModule::class,
    UseCasesModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MmrCheckerBookApp)
}