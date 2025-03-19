package io.eunmin.multiplatform.pokedex.feature.base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal interface StateHandler<State> {
    val state: StateFlow<State>

    fun changeState(action: (State) -> State)
}

abstract class StateViewModel<State>(initialState: State): DefaultViewModel(), StateHandler<State> {
    private val _state = MutableStateFlow(initialState)
    override val state: StateFlow<State> = _state.asStateFlow()

    override fun changeState(action: (State) -> State) { launch {
        _state.emit(action(_state.value))
    } }
}