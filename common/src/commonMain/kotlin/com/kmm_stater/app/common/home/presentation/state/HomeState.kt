package com.kmm_stater.app.common.home.presentation.state

data class HomeState(
    val isFailure: Boolean = false,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
)