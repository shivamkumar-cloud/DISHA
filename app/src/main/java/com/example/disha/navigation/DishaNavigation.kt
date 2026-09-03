package com.example.disha.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.disha.ui.screens.career.CareerSelectionScreen
import com.example.disha.ui.screens.dashboard.DashboardScreen
import com.example.disha.ui.screens.onboarding.OnboardingScreen
import com.example.disha.ui.screens.splash.SplashScreen

@Composable
fun DishaNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        composable(Screen.Splash.route) {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(Screen.Onboarding.route) {
                        popUpTo(Screen.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onContinue = {
                    navController.navigate(Screen.CareerSelection.route)
                }
            )
        }

        composable(Screen.CareerSelection.route) {
            CareerSelectionScreen(
                onCareerSelected = {
                    navController.navigate(Screen.Dashboard.route)
                }
            )
        }

        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }
    }
}