package com.lissene_kids.app.common.auth.presentation.login

import com.lissene_kids.app.common.auth.data.local.tokenSettings
import com.lissene_kids.app.common.auth.domain.repository.AuthRepository
import com.lissene_kids.app.common.auth.domain.util.toCommonStateFlow
import com.lissene_kids.app.common.auth.presentation.login.event.LoginEvent
import com.lissene_kids.app.common.auth.presentation.login.state.LogInInputState
import com.lissene_kids.app.common.auth.presentation.login.state.LoginState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginViewModel(
    coroutineScope: CoroutineScope? = null
): KoinComponent {
    private val repository: AuthRepository by inject()

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(LoginState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            LoginState()
        )
        .toCommonStateFlow()

    private val _logInInputState = MutableStateFlow(LogInInputState())
    val logInInputState = _logInInputState
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            LogInInputState()
        )
        .toCommonStateFlow()

    init {
        val refreshToken = tokenSettings.getString("refreshToken", "")
        if (refreshToken.isNotEmpty()) {
            _state.update { it.copy(
                isSuccess = true
            )}
        }
    }

    fun onEvent(event: LoginEvent){
        when(event) {
            is LoginEvent.HidePassword -> {
                _logInInputState.update { it.copy(
                    isPasswordVisible = false
                )}
            }

            is LoginEvent.ShowPassword -> {
                _logInInputState.update { it.copy(
                    isPasswordVisible = true
                )}
            }

            is LoginEvent.Login -> {
                val isValid = verifyLoginInput(
                    email = _logInInputState.value.email,
                )

                if (isValid) {
                    _logInInputState.update {
                        it.copy(
                            isInputValid = true,
                        )
                    }
                    login(_logInInputState.value.email,_logInInputState.value.password)
                } else {
                    _logInInputState.update {
                        it.copy(
                            isInputValid = false
                        )
                    }
                }
            }

            is LoginEvent.TypeEmail -> _logInInputState.update {
                it.copy(email = event.email)
            }

            is LoginEvent.TypePassword -> _logInInputState.update {
                it.copy(password = event.password)
            }

            else -> {}
        }
    }

    fun login(email: String,password: String) {
        if (_state.value.isLoading || _state.value.isSuccess) return

        _state.value = LoginState(isLoading = true)

        viewModelScope.launch {

            repository
                .login(email = email, password = password)
                .onSuccess {
                    _state.value = LoginState(isSuccess = true)
                }
                .onFailure {
                    _state.value = LoginState(isFailure = true)
                }
        }
    }

    private fun verifyLoginInput(email : String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

        return (email.matches(emailRegex.toRegex()))
    }
}



