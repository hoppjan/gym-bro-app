package de.janhopp.gymbro.model.execution

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
