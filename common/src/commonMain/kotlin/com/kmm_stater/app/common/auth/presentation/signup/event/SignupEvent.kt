package com.kmm_stater.app.common.auth.presentation.signup.event

import com.kmm_stater.app.common.auth.domain.model.SignupInput

sealed class SignupEvent{
    data class Signup(val signupInput: SignupInput) : SignupEvent()
    data class TypeName(val name: String): SignupEvent()
    data class TypeLastName(val lastName: String): SignupEvent()
    data class TypeEmail(val email: String): SignupEvent()
    data class TypePhoneNumber(val phoneNumber: String): SignupEvent()
    data class TypePassword(val password: String): SignupEvent()
    object AlreadyHaveAccount : SignupEvent()
    object RememberMe : SignupEvent()
}