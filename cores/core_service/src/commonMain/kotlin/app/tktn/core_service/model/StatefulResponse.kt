package app.tktn.core_service.model

sealed class StatefulResponse<out T> {
    val succeeded
        get() = this is Success

    data class Success<T>(val data: DomainResult<T>) : StatefulResponse<T>()
    data class Error(val exception: Throwable) : StatefulResponse<Nothing>()
}