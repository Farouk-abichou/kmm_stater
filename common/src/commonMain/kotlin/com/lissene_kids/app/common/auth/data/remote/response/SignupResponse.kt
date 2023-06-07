package com.lissene_kids.app.common.auth.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class SignupResponse(
    val data: SignupData?
)

@Serializable
data class SignupData(
    val user: User
)

@Serializable
data class User(
    val _id: String,
    val brandPicUrl: String,
    val email: String,
    val name: String,
    val profilePicUrl: String,
    val roles: List<Role>,
    val verified: Boolean
)

@Serializable
data class Role(
    val _id: String,
    val code: String
)