package de.janhopp.gymbro.model.execution

interface Set {
    val id: Long
    val index: Int
}

data class WeightSet(
    override val id: Long,
    override val index: Int,
    val weight: Int,
    val reps: Int,
) : Set

data class BodyWeightSet(
    override val id: Long,
    override val index: Int,
    val reps: Int,
) : Set

data class CardioSet(
    override val id: Long,
    override val index: Int,
    val duration: Int,
) : Set
