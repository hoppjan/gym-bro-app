package de.janhopp.gymbro.model.exercise

data class Weight(
    val value: Int,
    val unit: WeightUnit,
)

enum class WeightUnit {
    KILOGRAMS,
    POUNDS,
    ;
}
