package de.janhopp.gymbro.model.execution

import de.janhopp.gymbro.model.planning.PlannedExercise

data class ExerciseExecution(
    val exercise: PlannedExercise,
    val sets: List<Set>,
)
