package ru.android.anothermvvmrandomdog.data.converters

import ru.android.anothermvvmrandomdog.data.DogDto
import ru.android.anothermvvmrandomdog.domain.model.Dog

fun DogDto.toDomain(): Dog = Dog(
    message = message,
    status = status
)