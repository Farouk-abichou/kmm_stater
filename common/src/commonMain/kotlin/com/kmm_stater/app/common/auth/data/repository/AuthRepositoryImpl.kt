package com.kmm_stater.app.common.auth.data.repository

import com.kmm_stater.app.common.auth.data.remote.AuthClient
import com.kmm_stater.app.common.auth.data.remote.response.SignupResponse
import com.kmm_stater.app.common.auth.domain.model.SignupInput
import com.kmm_stater.app.common.auth.data.remote.response.Token
import com.kmm_stater.app.common.auth.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthRepositoryImpl : AuthRepository, KoinComponent {
    private val client by inject<AuthClient>()

    override suspend fun login(
        email: String,
        password: String
    ): Result<Token> = withContext(Dispatchers.IO) {
        try {
            val result = client.login(email, password)
            Result.success(result.data.tokens.toToken())
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun signup(
        signupInput: SignupInput
    ): Result<SignupResponse> {
        return try {
            val response = client.signup(signupInput)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun refreshToken(): Result<Token> {
        return try {
            val response = client.refreshToken()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}