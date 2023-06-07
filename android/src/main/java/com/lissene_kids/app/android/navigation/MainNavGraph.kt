package com.lissene_kids.app.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
//            val viewModel = viewModel<AndroidLoginViewModel>()
//
//            LogInScreen(
//                viewModel = viewModel,
//                onEvent = viewModel::onEvent,
//                navigateToHome = {
//                    navController.navigate(
//                        Routes.Video.route + "/6475ef27d862952b0d402d3d"
//                    ) {
//                        popUpTo(Routes.Login.route) {
//                            inclusive = true
//                        }
//                    }
//                    navController.navigate(Routes.Home.route) {
//                        popUpTo(Routes.Login.route) {
//                            inclusive = true
//                        }
//                    }
//                },
//                navigateToSignup = {}
//            )
        }
    }
}