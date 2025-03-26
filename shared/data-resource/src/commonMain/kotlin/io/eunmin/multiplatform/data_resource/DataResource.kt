package io.eunmin.multiplatform.data_resource

sealed interface DataResource<out T> {
    data class Success<T>(val data: T) : DataResource<T>
    data class Error(val throwable: Throwable) : DataResource<Nothing>
    data class Loading<T>(val data: T?) : DataResource<T>

    companion object {
        fun <T> success(data: T) = Success(data)
        fun error(throwable: Throwable) = Error(throwable)
        fun <T>loading(data: T? = null) = Loading(data)
    }
}