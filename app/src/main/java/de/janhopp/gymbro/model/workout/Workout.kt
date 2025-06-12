package de.janhopp.gymbro.model.workout

import de.janhopp.gymbro.model.exercise.ExerciseExecution

data class Workout(
    val id: Long,
    val routine: WorkoutRoutine,
    val executions: List<ExerciseExecution>,
)
