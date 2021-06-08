package ru.android.anothermvvmrandomdog.domain

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrandomdog.domain.model.Dog

interface DogInteractor {

    fun getDog(): LiveData<Result<Dog>>

}