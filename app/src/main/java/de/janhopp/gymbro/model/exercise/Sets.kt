package de.janhopp.gymbro.model.exercise

data class Sets(
    val id: Long,
    val subsets: List<Subset>
)

data class Subset(
    val id: Long,
    val reps: Int,
    val weight: Weight,
)
