package ru.android.anothermvvmrandomdog.domain

import ru.android.anothermvvmrandomdog.domain.model.Dog

interface DogDataSource {

    fun getDog(): Dog

}