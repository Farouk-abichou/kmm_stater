package com.lissene_kids.app.android.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lissene_kids.app.common.auth.presentation.signup.SignupViewModel
import com.lissene_kids.app.common.auth.presentation.signup.event.SignupEvent

class AndroidHomeViewModel : ViewModel() {
    private val viewModel = SignupViewModel(
        coroutineScope = viewModelScope,
    )

    val state = viewModel.state
    val signUpInputState = viewModel.signUpInputState

    fun onEvent(event: SignupEvent){
        viewModel.onEvent(event)

    }
}