package de.janhopp.gymbro.model.execution

import de.janhopp.gymbro.model.planning.WorkoutPlan
import java.util.Date

data class WorkoutExecution(
    val id: Int,
    val start: Date,
    val finish: Date,
    val workoutPlan: WorkoutPlan,
    val exerciseExecutions: List<ExerciseExecution>,
)
