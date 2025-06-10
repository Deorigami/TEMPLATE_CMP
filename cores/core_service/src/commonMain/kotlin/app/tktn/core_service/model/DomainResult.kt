package app.tktn.core_service.model

class DomainResult<T>(
    val data : T? = null,
    val message : String? = null,
    val status : Boolean = true,
    val code: Int = 200
){
    companion object {
        data class ErrorMessageInBody(
            val error : String? = null
        )
    }
}