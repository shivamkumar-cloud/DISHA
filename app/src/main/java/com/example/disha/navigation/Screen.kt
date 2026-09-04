sealed class Screen(val route: String) {

    object Splash : Screen("splash")

    object Onboarding : Screen("onboarding")

    object CareerSelection : Screen("career_selection")

    object SkillAssessment : Screen("skill_assessment")

    object DirectionResult : Screen("direction_result")

    object Dashboard : Screen("dashboard")
}