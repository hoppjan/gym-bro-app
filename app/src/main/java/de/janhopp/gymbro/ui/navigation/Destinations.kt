package de.janhopp.gymbro.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {
    @Serializable data object WorkoutRoutinePicker : Destination
    @Serializable data class WorkoutRoutineOverview(val routineId: Int) : Destination
}
