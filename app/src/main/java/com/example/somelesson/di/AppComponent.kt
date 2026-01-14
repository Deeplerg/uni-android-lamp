package com.example.somelesson.di

import com.example.somelesson.di.viewModel.ViewModelModule
import com.example.somelesson.presenter.MainFragment
import dagger.Component
import dagger.Module

@Component(
    modules = [
        AppModule::class
    ]
)
abstract class AppComponent {

    abstract fun inject(fragment: MainFragment)
}

@Module(
    includes = [
        NetworkModule::class,
        AppBindsModule::class,
        ViewModelModule::class
    ]
)
class AppModule