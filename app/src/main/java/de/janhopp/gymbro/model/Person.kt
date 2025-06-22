package de.janhopp.gymbro.model

import de.janhopp.gymbro.model.planning.WorkoutPlan

data class Person(
    val id: Int,
    val name: String,
    val workoutPlans: List<WorkoutPlan> = emptyList(),
)
