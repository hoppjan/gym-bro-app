package de.janhopp.gymbro.model.planning

import de.janhopp.gymbro.db.model.ExerciseType
import de.janhopp.gymbro.db.model.planning.PlannedExerciseTable
import de.janhopp.gymbro.model.exercise.Weight

sealed interface PlannedExercise {
    val id: Int
    val name: String
    val index: Int
    val pauseInBetween: Int
    val pauseAfterwards: Int
    val description: String?
    val equipment: String?
    val muscleGroup: String?
}

data class WeightExercise(
    override val id: Int,
    override val name: String,
    override val index: Int,
    override val pauseInBetween: Int,
    override val pauseAfterwards: Int,
    override val description: String?,
    override val equipment: String?,
    override val muscleGroup: String?,
    val sets: Int,
    val reps: Int,
    val weight: Weight,

    ) : PlannedExercise

data class BodyWeightExercise(
    override val id: Int,
    override val name: String,
    override val index: Int,
    override val pauseInBetween: Int,
    override val pauseAfterwards: Int,
    override val description: String?,
    override val equipment: String?,
    override val muscleGroup: String?,
    val sets: Int,
    val reps: Int,
) : PlannedExercise

data class CardioExercise(
    override val id: Int,
    override val name: String,
    override val index: Int,
    override val pauseInBetween: Int,
    override val pauseAfterwards: Int,
    override val description: String?,
    override val equipment: String?,
    override val muscleGroup: String?,
    val duration: Int,
) : PlannedExercise

fun PlannedExerciseTable.toPlannedExercise(): PlannedExercise = when (type) {
    ExerciseType.WEIGHT -> WeightExercise(
        id,
        name,
        index,
        pauseInBetween,
        pauseAfterwards,
        description,
        equipment,
        muscleGroup,
        sets!!,
        reps!!,
        weight!!,
    )

    ExerciseType.BODY_WEIGHT -> BodyWeightExercise(
        id,
        name,
        index,
        pauseInBetween,
        pauseAfterwards,
        description,
        equipment,
        muscleGroup,
        sets!!,
        reps!!,
    )

    ExerciseType.CARDIO -> CardioExercise(
        id,
        name,
        index,
        pauseInBetween,
        pauseAfterwards,
        description,
        equipment,
        muscleGroup,
        duration!!,
    )
}

fun PlannedExercise.toPlannedExerciseTable(): PlannedExerciseTable = when (this) {
    is WeightExercise -> PlannedExerciseTable(
        id,
        ExerciseType.WEIGHT,
        name,
        index,
        pauseInBetween,
        pauseAfterwards,
        description,
        equipment,
        muscleGroup,
        sets,
        reps,
        weight = weight,
        duration = null,
    )

    is BodyWeightExercise -> PlannedExerciseTable(
        id,
        ExerciseType.BODY_WEIGHT,
        name,
        index,
        pauseInBetween,
        pauseAfterwards,
        description,
        equipment,
        muscleGroup,
        sets,
        reps,
        weight = null,
        duration = null,
    )

    is CardioExercise -> PlannedExerciseTable(
        id,
        ExerciseType.CARDIO,
        name,
        index,
        pauseInBetween,
        pauseAfterwards,
        description,
        equipment,
        muscleGroup,
        sets = null,
        reps = null,
        weight = null,
        duration = null,
    )
}
