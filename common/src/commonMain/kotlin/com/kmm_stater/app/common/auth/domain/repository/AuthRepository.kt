package com.kmm_stater.app.common.auth.domain.repository

import com.kmm_stater.app.common.auth.data.remote.response.SignupResponse
import com.kmm_stater.app.common.auth.domain.model.SignupInput
import com.kmm_stater.app.common.auth.data.remote.response.Token

interface AuthRepository {

    suspend fun login(email : String, password : String) : Result<Token>

    suspend fun signup(signupInput : SignupInput) : Result<SignupResponse>

    suspend fun refreshToken(): Result<Token>

}