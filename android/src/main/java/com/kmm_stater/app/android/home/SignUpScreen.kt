package com.kmm_stater.app.android.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.kmm_stater.app.android.auth.signup.AndroidSignupViewModel
import com.kmm_stater.app.android.auth.signup.SignUpScreen
import com.kmm_stater.app.android.theme.KMMSTheme
import com.kmm_stater.app.common.auth.presentation.signup.event.SignupEvent

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
    KMMSTheme {
        SignUpScreen(
            viewModel = AndroidSignupViewModel(),
            onEvent = {},
            navigateToHome = {},
            navigateToLogin = {},
        )
    }
}
