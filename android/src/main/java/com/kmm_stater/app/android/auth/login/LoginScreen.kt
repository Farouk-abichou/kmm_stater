package com.kmm_stater.app.android.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kmm_stater.app.android.theme.KMMSTheme
import com.kmm_stater.app.common.auth.presentation.login.event.LoginEvent

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

    //Screen Content
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Hello World!")
    }


}

@Preview
@Composable
private fun LogInScreenPreview() {
    KMMSTheme {
        LogInScreen(
            viewModel = AndroidLoginViewModel(),
            onEvent = {},
            navigateToSignup = {},
            navigateToHome = {},
        )
    }
}