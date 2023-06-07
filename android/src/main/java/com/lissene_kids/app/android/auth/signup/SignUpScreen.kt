package com.lissene_kids.app.android.auth.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.lissene_kids.app.android.theme.LkTheme
import com.lissene_kids.app.common.auth.presentation.signup.event.SignupEvent

@Composable
fun SignUpScreen(
    viewModel: AndroidSignupViewModel,
    onEvent: (SignupEvent) -> Unit,
    navigateToHome: () -> Unit,
    navigateToLogin: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess) {
            navigateToHome()
        }
    }

//    Scaffold { paddingValues ->

        //Screen Content

//    }

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
