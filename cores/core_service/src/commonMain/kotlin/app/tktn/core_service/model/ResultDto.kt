package app.tktn.core_service.model

//import de.jensklingenberg.ktorfit.Response
//import io.ktor.client.plugins.ClientRequestException
import kotlinx.serialization.Serializable


@Serializable
data class ResultDto<DTO>(
    val data: DTO? = null,
    val message: String? = "",
    val status: Boolean? = null,
) {
    companion object {
        fun <ENTITY, DTO> ResultDto<DTO>.toDomainResult(block: (DTO) -> ENTITY): DomainResult<ENTITY> {
            return DomainResult(
                data?.let { block.invoke(it) },
                message,
                status = status ?: false
            )
        }
//        fun <ENTITY, DTO> Response<ResultDto<DTO>>.toDomainResult(block: (DTO) -> ENTITY): DomainResult<ENTITY> {
//            if (this.isSuccessful.not()) throw ClientRequestException(raw(), "")
//            return DomainResult(
//                this.body()?.data?.let { block.invoke(it) },
//                message,
//                this.body()?.status ?: (code in 200..204),
//                code = code
//            )
//        }
    }
}