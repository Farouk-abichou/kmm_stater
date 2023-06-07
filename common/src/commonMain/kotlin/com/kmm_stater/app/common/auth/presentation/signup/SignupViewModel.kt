package com.kmm_stater.app.common.auth.presentation.signup

import com.kmm_stater.app.common.auth.domain.model.SignupInput
import com.kmm_stater.app.common.auth.domain.repository.AuthRepository
import com.kmm_stater.app.common.auth.domain.util.toCommonStateFlow
import com.kmm_stater.app.common.auth.presentation.signup.event.SignupEvent
import com.kmm_stater.app.common.auth.presentation.signup.state.SignupInputState
import com.kmm_stater.app.common.auth.presentation.signup.state.SignupState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignupViewModel(
    coroutineScope: CoroutineScope? = null,
): KoinComponent {
    private val repository: AuthRepository by inject()

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(SignupState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted
                .WhileSubscribed(5000),
            SignupState()
        )
        .toCommonStateFlow()

    private val _signUpInputState = MutableStateFlow(SignupInputState())
    val signUpInputState = _signUpInputState.asStateFlow()

    fun onEvent(event: SignupEvent){
        when(event){

            is SignupEvent.AlreadyHaveAccount -> {
                _signUpInputState.update { it.copy(
                    alreadyHaveAccount = true
                )}
            }

            is SignupEvent.RememberMe -> {}

            is SignupEvent.TypeName -> {
                _signUpInputState.update {
                    it.copy(firstName = event.name)
                }
            }
            is SignupEvent.TypeLastName -> {
                _signUpInputState.update {
                    it.copy(lastName = event.lastName)
                }
            }
            is SignupEvent.TypeEmail -> {
                _signUpInputState.update {
                    it.copy(email = event.email)
                }
            }
            is SignupEvent.TypePhoneNumber -> {
                _signUpInputState.update {
                    it.copy(phoneNumber = event.phoneNumber)
                }
            }
            is SignupEvent.TypePassword -> {
                _signUpInputState.update {
                    it.copy(password = event.password)
                }
            }

            is SignupEvent.Signup -> {
                val input = SignupInput(
                    _signUpInputState.value.firstName,
                    _signUpInputState.value.lastName,
                    _signUpInputState.value.email,
                    _signUpInputState.value.phoneNumber,
                    _signUpInputState.value.password,
                )

                if (verifySignupInput(input)){

                    _signUpInputState.update {
                        it.copy(
                            isInputValid = true
                        )
                    }

                    signUp(input)
                } else {
                    _signUpInputState.update {
                        it.copy(
                            isInputValid = false
                        )
                    }
                }
            }
        }
    }


    private fun signUp(signupInput: SignupInput){
        if (_state.value.isLoading || _state.value.isSuccess) return

        _state.value = SignupState(isSuccess = true)

        viewModelScope.launch {

            repository
                .signup(signupInput)
                .onSuccess {
                    _state.value = SignupState(isSuccess = true)
                }
                .onFailure {
                    _state.value = SignupState(isFailure = true)
                }
        }
    }


    private fun verifySignupInput(signupInput : SignupInput): Boolean {
        val nameValidation = (
                signupInput.firstName.length > 2
        )
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

        val emailValidation =  signupInput.email.matches(emailRegex.toRegex())
        val phoneNumberValidation =  (signupInput.phoneNumber.length == 8 && signupInput.phoneNumber.toDoubleOrNull() != null)

        val passwordValidation =  signupInput.password.length >= 8


        return (nameValidation && emailValidation && phoneNumberValidation && passwordValidation)
    }

}