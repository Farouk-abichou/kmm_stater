package com.lissene_kids.app.android.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.lissene_kids.app.android.auth.signup.AndroidSignupViewModel
import com.lissene_kids.app.android.auth.signup.SignUpScreen
import com.lissene_kids.app.android.theme.LkTheme
import com.lissene_kids.app.common.auth.presentation.signup.event.SignupEvent

@Composable
fun HomeScreen(
    viewModel: AndroidHomeViewModel,
    onEvent: (SignupEvent) -> Unit,
) {
    val state by viewModel.state.collectAsState()
    val signUpInputState by viewModel.signUpInputState.collectAsState()

    //Screen Content

}

@Preview
@Composable
private fun SignUpScreenPreview1() {
    LkTheme {
        SignUpScreen(
            viewModel = AndroidSignupViewModel(),
            onEvent = {},
            navigateToHome = {},
            navigateToLogin = {},
        )
    }
}
