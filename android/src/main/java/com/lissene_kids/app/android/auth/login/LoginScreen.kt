package com.lissene_kids.app.android.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.lissene_kids.app.android.theme.ImTheme
import com.lissene_kids.app.common.auth.presentation.login.event.LoginEvent

@Composable
fun LogInScreen(
    viewModel: AndroidLoginViewModel,
    onEvent: (LoginEvent) -> Unit,
    navigateToHome: () -> Unit,
    navigateToSignup: () -> Unit,
) {
    val state by viewModel.state.collectAsState()
    val logInInputState by viewModel.logInInputState.collectAsState()

    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess) {
            navigateToHome()
        }
    }

    Scaffold { paddingValues ->

        //Screen Content

    }
}

@Preview
@Composable
fun LogInScreenPreview() {
    ImTheme {
        LogInScreen(
            viewModel = AndroidLoginViewModel(),
            onEvent = {},
            navigateToSignup = {},
            navigateToHome = {},
        )
    }
}