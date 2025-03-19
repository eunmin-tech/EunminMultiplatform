package io.eunmin.multiplatform.pokedex.feature.base

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<State, SideEffect>(initialState: State):
    DefaultViewModel(), StateHandler<State>, SideEffectHandler<SideEffect> {
    private val _state = MutableStateFlow(initialState)
    override val state: StateFlow<State> = _state.asStateFlow()

    private val _sideEffectChannel = MutableSharedFlow<SideEffect>()
    override val sideEffect: SharedFlow<SideEffect> = _sideEffectChannel.asSharedFlow()

    override fun changeState(action: (State) -> State) { launch {
        _state.emit(action(_state.value))
    } }

    override fun publishSideEffect(vararg sideEffect: SideEffect) { launch {
        sideEffect.forEach { _sideEffectChannel.emit(it) }
    } }
}