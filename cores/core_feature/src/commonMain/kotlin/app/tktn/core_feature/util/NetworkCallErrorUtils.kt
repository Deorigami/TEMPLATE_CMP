package app.tktn.core_feature.util

import app.tktn.core_service.model.NetworkCallErrorModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

object NetworkCallErrorUtils {
    private val _errors = MutableStateFlow<List<NetworkCallErrorModel>>(emptyList())
    val errors: StateFlow<List<NetworkCallErrorModel>> get() = _errors.asStateFlow()

    fun addError(
        error: NetworkCallErrorModel,
        autoRemoveDelayMs: Long = 5000 // Default 5 seconds
    ) {
        _errors.value = _errors.value + error

        // Launch a coroutine to remove the error after specified delay
        CoroutineScope(Dispatchers.Default + SupervisorJob()).launch {
            delay(autoRemoveDelayMs)
            removeError(error)
        }
    }

    fun removeError(error: NetworkCallErrorModel) {
        _errors.value = _errors.value - error
    }

    fun clearErrors() {
        _errors.value = emptyList()
    }
}