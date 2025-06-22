package de.janhopp.gymbro.model

import de.janhopp.gymbro.model.planning.WorkoutPlan
import java.util.Date

data class Person(
    val id: Int,
    val name: String,
    val birthday: Date,
    val workoutPlans: List<WorkoutPlan> = emptyList(),
)
