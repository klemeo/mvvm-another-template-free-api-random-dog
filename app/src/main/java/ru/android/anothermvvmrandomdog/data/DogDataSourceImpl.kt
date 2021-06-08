package ru.android.anothermvvmrandomdog.data

import ru.android.anothermvvmrandomdog.base.RetrofitDataSource
import ru.android.anothermvvmrandomdog.data.converters.toDomain
import ru.android.anothermvvmrandomdog.domain.DogDataSource
import ru.android.anothermvvmrandomdog.domain.model.Dog

class DogDataSourceImpl : DogDataSource, RetrofitDataSource {

    override fun getDog(): Dog {
        val result = executeWithResponse {
            PostApiClient.getApiClient().getDog()
        }
        return result.toDomain()
    }

}