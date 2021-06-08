package ru.android.anothermvvmrandomdog.data

import ru.android.anothermvvmrandomdog.domain.model.Dog

fun DogDto.toDomain(): Dog = Dog(
    message = message,
    status = status
)