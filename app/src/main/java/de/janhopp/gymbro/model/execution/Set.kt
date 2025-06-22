package de.janhopp.gymbro.model.execution

import de.janhopp.gymbro.db.model.ExerciseType
import de.janhopp.gymbro.db.model.execution.SetTable
import de.janhopp.gymbro.model.exercise.Weight

sealed interface Set {
    val id: Int
    val index: Int
}

data class WeightSet(
    override val id: Int,
    override val index: Int,
    val weight: Weight,
    val reps: Int,
) : Set

data class BodyWeightSet(
    override val id: Int,
    override val index: Int,
    val reps: Int,
) : Set

data class CardioSet(
    override val id: Int,
    override val index: Int,
    val duration: Int,
) : Set

fun SetTable.toWeightSet() = WeightSet(id, index, weight!!, reps!!)
fun SetTable.toBodyWeightSet() = BodyWeightSet(id, index, reps!!)
fun SetTable.toCardioSet() = CardioSet(id, index, duration!!)

fun SetTable.toSet(type: ExerciseType) = when (type) {
    ExerciseType.WEIGHT -> toWeightSet()
    ExerciseType.BODY_WEIGHT -> toBodyWeightSet()
    ExerciseType.CARDIO -> toCardioSet()
}

fun Set.toSetTable(exerciseExecutionId: Int) = when (this) {
    is WeightSet -> SetTable(id, index, exerciseExecutionId, reps = reps, weight = weight, duration = null)
    is BodyWeightSet -> SetTable(id, index, exerciseExecutionId, reps = reps, weight = null, duration = null)
    is CardioSet -> SetTable(id, index, exerciseExecutionId, null, null, duration)
}
