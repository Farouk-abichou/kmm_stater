package com.lissene_kids.app.android.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.lissene_kids.app.android.auth.signup.AndroidSignupViewModel
import com.lissene_kids.app.android.auth.signup.SignUpScreen
import com.lissene_kids.app.android.theme.ImTheme
import com.lissene_kids.app.common.auth.presentation.signup.event.SignupEvent

@Composable
fun HomeScreen(
    viewModel: AndroidHomeViewModel,
    onEvent: (SignupEvent) -> Unit,
) {
    val state by viewModel.state.collectAsState()
    val signUpInputState by viewModel.signUpInputState.collectAsState()


    Scaffold {  paddingValues ->

        //Screen Content

    }

}

@Preview
@Composable
private fun SignUpScreenPreview1() {
    ImTheme {
        SignUpScreen(
            viewModel = AndroidSignupViewModel(),
            onEvent = {},
            navigateToHome = {},
            navigateToLogin = {},
        )
    }
}
