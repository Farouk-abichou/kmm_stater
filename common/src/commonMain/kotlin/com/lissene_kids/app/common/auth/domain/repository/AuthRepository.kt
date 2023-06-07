package com.lissene_kids.app.common.auth.domain.repository

import com.lissene_kids.app.common.auth.data.remote.response.SignupResponse
import com.lissene_kids.app.common.auth.domain.model.SignupInput
import com.lissene_kids.app.common.auth.data.remote.response.Token

interface AuthRepository {

    suspend fun login(email : String, password : String) : Result<Token>

    suspend fun signup(signupInput : SignupInput) : Result<SignupResponse>

    suspend fun refreshToken(): Result<Token>

}