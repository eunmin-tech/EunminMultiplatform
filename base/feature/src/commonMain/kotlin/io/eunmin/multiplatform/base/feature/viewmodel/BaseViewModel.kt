package io.eunmin.multiplatform.base.feature.viewmodel

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseViewModel<SideEffect>:
    DefaultViewModel(), SideEffectHandler<SideEffect> {

    private val _sideEffectChannel = MutableSharedFlow<SideEffect>()
    override val sideEffect: SharedFlow<SideEffect> = _sideEffectChannel.asSharedFlow()

    override fun publishSideEffect(vararg sideEffect: SideEffect) { launch {
        sideEffect.forEach { _sideEffectChannel.emit(it) }
    } }
}