package ru.android.anothermvvmrandomdog.presentation

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.android.anothermvvmrandomdog.base.ResultObserverDelegate
import ru.android.anothermvvmrandomdog.domain.DogInteractor
import ru.android.anothermvvmrandomdog.domain.model.Dog

class HomeViewModel(
    private val dogInteractor: DogInteractor
) : ViewModel() {

    val imageDog = ObservableField<String>()

    private var getDogObserver = Observer<Result<Dog>> { result ->
        handleDogResult(result)
    }

    private var getDogLiveData: LiveData<Result<Dog>>?
            by ResultObserverDelegate(getDogObserver)

    fun getDog() {
        getDogLiveData = dogInteractor.getDog()
    }

    private fun handleDogResult(result: Result<Dog>) {
        result
            .onSuccess {
                setImage(it)

            }
            .onFailure {

            }
    }

    private fun setImage(data: Dog) {
        imageDog.set(data.message)
    }

}