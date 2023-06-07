package com.lissene_kids.app.android.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lissene_kids.app.android.auth.login.AndroidLoginViewModel
import com.lissene_kids.app.android.auth.login.LogInScreen

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
    }
}