package app.tktn.core_service.model


data class Error(
    var status : Boolean,
    var message : String?,
    var code: Int
)
