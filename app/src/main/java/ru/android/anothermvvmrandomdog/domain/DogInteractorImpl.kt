package ru.android.anothermvvmrandomdog.domain

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrandomdog.domain.model.Dog
import ru.android.anothermvvmrandomdog.base.CoroutineInteractor
import ru.android.anothermvvmrandomdog.base.scopedLiveData

class DogInteractorImpl(
    private val dogDataSource: DogDataSource
) : CoroutineInteractor(), DogInteractor {

    override fun getDog(): LiveData<Result<Dog>> = scopedLiveData {
        try {
            val result = dogDataSource.getDog()
            emit(Result.success(result))
        } catch (e: Exception) {

        }
    }

}