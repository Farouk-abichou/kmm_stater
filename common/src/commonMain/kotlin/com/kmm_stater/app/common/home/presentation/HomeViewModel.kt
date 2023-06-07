package com.kmm_stater.app.common.home.presentation

import com.kmm_stater.app.common.auth.domain.util.toCommonStateFlow
import com.kmm_stater.app.common.home.domain.repository.HomeRepository
import com.kmm_stater.app.common.home.presentation.event.HomeEvent
import com.kmm_stater.app.common.home.presentation.state.HomeState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel(
    coroutineScope: CoroutineScope? = null,
): KoinComponent {
    private val repository: HomeRepository by inject()

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(HomeState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted
                .WhileSubscribed(5000),
            HomeState()
        )
        .toCommonStateFlow()

    fun onEvent(event: HomeEvent){
        when(event){


            else -> {}
        }
    }
}