package de.janhopp.gymbro.model.exercise

data class ExerciseExecution(
    val exercise: Exercise,
    val sets: List<Subset>,
)
