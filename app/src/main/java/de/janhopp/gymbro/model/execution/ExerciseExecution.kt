package de.janhopp.gymbro.model.execution

import de.janhopp.gymbro.model.planning.Exercise

data class ExerciseExecution(
    val exercise: Exercise,
    val sets: List<Set>,
)
