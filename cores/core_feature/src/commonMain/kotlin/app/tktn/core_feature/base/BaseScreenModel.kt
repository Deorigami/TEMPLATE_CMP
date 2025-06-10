package app.tktn.core_feature.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.tktn.core_service.base.BaseUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

abstract class BaseScreenModel<UiState, Event>(
    initialState: UiState
) : ViewModel() {
    protected val _uiState: MutableStateFlow<UiState> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()
    protected open val registerLoadingListener: List<BaseUseCase<*, *>> = emptyList()
    protected val currentState get() = _uiState.value
    val isLoading by lazy {
        combine(registerLoadingListener.map { it.isLoading }) {
            it.any { it }
        }.stateIn(viewModelScope, SharingStarted.Lazily, false)
    }

    abstract fun onEvent(event: Event)
    protected fun updateState(newState: (UiState) -> UiState) {
        _uiState.update { newState(it) }
    }

}

abstract class BaseScreenModel2<UiState, Event> : ViewModel() {
    abstract val initialState: UiState
    protected val _uiState: MutableStateFlow<UiState> by lazy { MutableStateFlow(initialState) }
    val uiState = _uiState.asStateFlow()
    protected open val registerLoadingListener: List<BaseUseCase<*, *>> = emptyList()
    protected val currentState get() = _uiState.value
    val isLoading by lazy {
        combine(registerLoadingListener.map { it.isLoading }) {
            it.any { it }
        }.stateIn(viewModelScope, SharingStarted.Lazily, false)
    }

    abstract fun onEvent(event: Event)
    protected fun updateState(newState: (UiState) -> UiState) {
        _uiState.update { newState(it) }
    }

}