package com.kmm_stater.app.android.auth.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.kmm_stater.app.android.theme.KMMSTheme
import com.kmm_stater.app.common.auth.presentation.signup.event.SignupEvent

@Composable
fun SignUpScreen(
    viewModel: AndroidSignupViewModel,
    onEvent: (SignupEvent) -> Unit,
    navigateToHome: () -> Unit,
    navigateToLogin: () -> Unit,
) {

    val state by viewModel.state.collectAsState()
    val signupInputState = viewModel.signupInputState.collectAsState()

    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess) {
            navigateToHome()
        }
    }

    //Screen Content

}

@Preview
@Composable
private fun SignUpScreenPreview1() {
    KMMSTheme {
        SignUpScreen(
            viewModel = AndroidSignupViewModel(),
            onEvent = {},
            navigateToHome = {},
            navigateToLogin = {},
        )
    }
}
