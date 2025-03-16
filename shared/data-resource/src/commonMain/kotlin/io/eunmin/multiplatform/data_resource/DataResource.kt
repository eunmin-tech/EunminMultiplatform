package io.eunmin.multiplatform.data_resource

sealed interface DataResource<out T> {
    class Success<T>(val data: T) : DataResource<T>
    class Error(val throwable: Throwable) : DataResource<Nothing>

    companion object {
        fun <T> success(data: T) = Success(data)
        fun error(throwable: Throwable) = Error(throwable)
    }
}