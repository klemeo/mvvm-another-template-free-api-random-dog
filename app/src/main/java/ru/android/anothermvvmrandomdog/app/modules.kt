package ru.android.anothermvvmrandomdog.app

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.android.anothermvvmrandomdog.data.DogDataSourceImpl
import ru.android.anothermvvmrandomdog.domain.DogDataSource
import ru.android.anothermvvmrandomdog.domain.DogInteractor
import ru.android.anothermvvmrandomdog.domain.DogInteractorImpl
import ru.android.anothermvvmrandomdog.presentation.HomeViewModel

private val allModules = module {

    viewModel {
        HomeViewModel(
            dogInteractor = get()
        )
    }

    single<DogDataSource> {
        DogDataSourceImpl()
    }


    single<DogInteractor> {
        DogInteractorImpl(
            dogDataSource = get()
        )
    }

}

val modules = listOf(allModules)
