package com.lissene_kids.app.common.auth.domain.model

data class SignupInput(
    val firstName : String,
    val lastName : String,
    val email : String,
    val phoneNumber : String,
    val password : String,
)
