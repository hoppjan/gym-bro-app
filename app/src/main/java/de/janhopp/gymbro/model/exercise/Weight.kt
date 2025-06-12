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

val Int.kg: Weight
    get() = Weight(this, WeightUnit.KILOGRAMS)

val Int.lb: Weight
    get() = Weight(this, WeightUnit.POUNDS)
