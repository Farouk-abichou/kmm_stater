package com.lissene_kids.app.android.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lissene_kids.app.common.auth.presentation.login.LoginViewModel
import com.lissene_kids.app.common.auth.presentation.login.event.LoginEvent

class AndroidLoginViewModel : ViewModel() {
    private val viewModel = LoginViewModel(
        coroutineScope = viewModelScope
    )

    val state = viewModel.state
    val logInInputState = viewModel.logInInputState

    fun onEvent(event: LoginEvent) {
        viewModel.onEvent(event)
    }
}