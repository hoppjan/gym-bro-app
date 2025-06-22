package de.janhopp.gymbro.model.execution

import de.janhopp.gymbro.model.planning.WorkoutPlan

data class WorkoutExecution(
    val id: Long,
    val date: Long,
    val routine: WorkoutPlan,
    val executions: List<ExerciseExecution>,
)
