package io.eunmin.multiplatform.base.feature.viewmodel

import kotlinx.coroutines.flow.SharedFlow

internal interface SideEffectHandler<SideEffect> {
    val sideEffect: SharedFlow<SideEffect>

    fun publishSideEffect(vararg sideEffect: SideEffect)
}