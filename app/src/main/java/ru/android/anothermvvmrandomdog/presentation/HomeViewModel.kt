package ru.android.anothermvvmrandomdog.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.android.anothermvvmrandomdog.base.ResultObserverDelegate
import ru.android.anothermvvmrandomdog.domain.DogInteractor
import ru.android.anothermvvmrandomdog.domain.model.Dog

class HomeViewModel(
    private val dogInteractor: DogInteractor
) : ViewModel() {

    private val _dogLiveData: MutableLiveData<Dog> =
        MutableLiveData()
    val dogLiveData: LiveData<Dog>
        get() = _dogLiveData

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
                _dogLiveData.postValue(it)

            }
            .onFailure {

            }
    }

}