package app.tktn.core_service.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthDto(
    @SerialName("api_token")
    val apiToken: String,
    val name: String,
    val email: String,
    @SerialName("code_name") val codeName: String?
)