package de.janhopp.gymbro.model.execution

import de.janhopp.gymbro.model.planning.WorkoutRoutine

data class Workout(
    val id: Long,
    val date: Long,
    val routine: WorkoutRoutine,
    val executions: List<ExerciseExecution>,
)
