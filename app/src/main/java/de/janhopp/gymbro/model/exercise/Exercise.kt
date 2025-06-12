package de.janhopp.gymbro.model.exercise

sealed interface Exercise {
    val id: Long
    val name: String
    val description: String?
    val equipment: String?
    val muscleGroup: String?
}

data class WeightExercise(
    override val id: Long,
    override val name: String,
    override val description: String?,
    override val equipment: String?,
    override val muscleGroup: String?,
    val sets: Int,
    val reps: Int,
    val weight: Weight,
) : Exercise

data class BodyWeightExercise(
    override val id: Long,
    override val name: String,
    override val description: String?,
    override val equipment: String?,
    override val muscleGroup: String?,
    val sets: Int,
    val reps: Int,
) : Exercise

data class CardioExercise(
    override val id: Long,
    override val name: String,
    override val description: String?,
    override val equipment: String?,
    override val muscleGroup: String?,
    val duration: Duration,
) : Exercise
