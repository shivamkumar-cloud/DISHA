package com.example.disha.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.disha.viewmodel.DishaViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.disha.ui.screens.assessment.SkillAssessmentScreen
import com.example.disha.ui.screens.career.CareerSelectionScreen
import com.example.disha.ui.screens.dashboard.DashboardScreen
import com.example.disha.ui.screens.onboarding.OnboardingScreen
import com.example.disha.ui.screens.result.DirectionResultScreen
import com.example.disha.ui.screens.splash.SplashScreen


@Composable
fun DishaNavigation() {

    val navController = rememberNavController()
    val dishaViewModel: DishaViewModel = viewModel()

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
                onCareerSelected = { career ->

                    dishaViewModel.updateCareer(career)

                    navController.navigate(
                        Screen.SkillAssessment.route
                    )
                }
            )
        }

        composable(Screen.SkillAssessment.route) {
            SkillAssessmentScreen(
                onAssessmentCompleted = {
                    navController.navigate(Screen.DirectionResult.route)
                }
            )
        }

        composable(Screen.DirectionResult.route) {
            DirectionResultScreen(
                onContinue = {
                    navController.navigate(Screen.Dashboard.route)
                }
            )
        }

        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }
    }
}