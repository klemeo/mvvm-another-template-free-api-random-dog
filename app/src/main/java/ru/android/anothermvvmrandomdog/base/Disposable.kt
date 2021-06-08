package ru.android.anothermvvmrandomdog.base

interface Disposable {
    /**
     * Cancel running jobs.
     */
    fun dispose()
}