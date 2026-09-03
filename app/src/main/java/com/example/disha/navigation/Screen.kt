package com.example.disha.navigation

sealed class Screen(val route: String) {

    object Splash : Screen("splash")

    object Onboarding : Screen("onboarding")

    object CareerSelection : Screen("career_selection")

    object Dashboard : Screen("dashboard")
}