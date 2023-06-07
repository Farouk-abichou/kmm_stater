package com.kmm_stater.app.android.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kmm_stater.app.android.auth.login.AndroidLoginViewModel
import com.kmm_stater.app.android.auth.login.LogInScreen
import com.kmm_stater.app.android.auth.signup.AndroidSignupViewModel
import com.kmm_stater.app.android.auth.signup.SignUpScreen
import com.kmm_stater.app.android.home.AndroidHomeViewModel
import com.kmm_stater.app.android.home.HomeScreen

@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(
            route = Routes.Login.route,
        ) {
            val viewModel = viewModel<AndroidLoginViewModel>()

            LogInScreen(
                viewModel = viewModel,
                onEvent = viewModel::onEvent,
                navigateToHome = {
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.Login.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToSignup = {}
            )
        }
        composable(
            route = Routes.SignUp.route,
        ) {
            val viewModel = viewModel<AndroidSignupViewModel>()

            SignUpScreen(
                viewModel = viewModel,
                onEvent = viewModel::onEvent,
                navigateToHome = {
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.Login.route) {
                            inclusive = true
                        }
                    }
                },
                navigateToLogin = {}
            )
        }
        composable(
            route = Routes.Home.route,
        ) {
            val viewModel = viewModel<AndroidHomeViewModel>()

            HomeScreen(
                viewModel = viewModel,
                onEvent = viewModel::onEvent,
            )
        }
    }
}