package io.eunmin.multiplatform.pokedex.feature.base

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

internal interface SideEffectHandler<SideEffect> {
    val sideEffect: SharedFlow<SideEffect>

    fun publishSideEffect(vararg sideEffect: SideEffect)
}

abstract class SideEffectViewModel<SideEffect>: DefaultViewModel(), SideEffectHandler<SideEffect> {
    private val _sideEffectChannel = MutableSharedFlow<SideEffect>()
    override val sideEffect: SharedFlow<SideEffect> = _sideEffectChannel.asSharedFlow()

    override fun publishSideEffect(vararg sideEffect: SideEffect) { launch {
        sideEffect.forEach { _sideEffectChannel.emit(it) }
    } }
}