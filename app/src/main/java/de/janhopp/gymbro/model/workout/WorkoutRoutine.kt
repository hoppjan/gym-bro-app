package de.janhopp.gymbro.model.workout

import de.janhopp.gymbro.model.exercise.Exercise

data class WorkoutRoutine(
    val id: Long,
    val name: String,
    val description: String?,
    val exercises: List<Exercise>,
)
