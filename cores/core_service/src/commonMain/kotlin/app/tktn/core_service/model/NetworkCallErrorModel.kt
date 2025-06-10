package app.tktn.core_service.model

import kotlinx.datetime.Clock
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class NetworkCallErrorModel @OptIn(ExperimentalUuidApi::class) constructor(
    val message: String,
    val time: Long = Clock.System.now().epochSeconds,
    val id: String = Uuid.random().toString()
)
