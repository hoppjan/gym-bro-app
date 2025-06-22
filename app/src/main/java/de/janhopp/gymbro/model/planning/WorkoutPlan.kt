package de.janhopp.gymbro.model.planning

data class WorkoutPlan(
    val id: Int,
    val name: String,
    val description: String?,
    val icon: String?,
    val exercises: List<PlannedExercise> = emptyList(),
)
