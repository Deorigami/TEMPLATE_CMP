package app.tktn.core_service.base

import app.tktn.core_service.extension.either
import app.tktn.core_service.extension.toResult
import app.tktn.core_service.model.DomainResult
import app.tktn.core_service.model.StatefulResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseUseCase<P, R> {
    protected abstract val default: R
    private var job: Job? = null
    private var cacheJob: Job? = null
    private var lastExecuted: Long = 0
    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
    var result: R? = null
    abstract suspend fun build(param: P): DomainResult<R>
    open suspend fun buildCache(): DomainResult<R>? = null

    fun execute(
        coroutineScope: CoroutineScope,
        param: P,
        onResult: (StatefulResult<R>) -> Unit = {}
    ) {
        if (job?.isActive == true) return
        _isLoading.update { true }
        job = coroutineScope.launch {
            onResult(
                either {
                    build(param)
                }.toResult(default).also {
                    _isLoading.update { false }
                    job?.cancel()
                    job = null
                }.let {
                    result = (it as? StatefulResult.Success)?.data
                    it
                }
            )
        }
    }

    suspend fun execute(
        param: P,
        onResult: (StatefulResult<R>) -> Unit = {}
    ) {
        if (job?.isActive == true) return
        _isLoading.update { true }
        onResult(
            either {
                build(param)
            }.toResult(default).also {
                _isLoading.update { false }
                job?.cancel()
                job = null
            }.let {
                result = (it as? StatefulResult.Success)?.data
                it
            }
        )
    }

    fun executeCache(
        scope: CoroutineScope,
        onResult: (StatefulResult<R>) -> Unit
    ) {
        cacheJob = scope.launch {
            buildCache()?.let { onResult(either { it }.toResult(default)) }
        }
    }

    private fun shouldExecuteNewTask(): Boolean {
//        return System.currentTimeMillis() - lastExecuted >= 1000
        return true
    }

    fun cancel() {
        job?.cancel()
    }
}