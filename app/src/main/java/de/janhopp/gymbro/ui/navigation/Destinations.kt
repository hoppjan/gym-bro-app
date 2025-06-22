package de.janhopp.gymbro.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {
    @Serializable data object Onboarding : Destination
    @Serializable data object WorkoutPlanPicker : Destination
    @Serializable data class WorkoutPlanOverview(val workoutPlanId: Int) : Destination
}
