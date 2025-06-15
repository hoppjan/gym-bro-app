package de.janhopp.gymbro.model.exercise

import androidx.room.TypeConverter

data class Weight(
    val value: Int,
    val unit: WeightUnit,
)

enum class WeightUnit {
    KILOGRAMS,
    POUNDS,
    ;

    override fun toString(): String = when (this) {
        KILOGRAMS -> "kg"
        POUNDS -> "lb"
    }
}

val Int.kg: Weight
    get() = Weight(this, WeightUnit.KILOGRAMS)

val Int.lb: Weight
    get() = Weight(this, WeightUnit.POUNDS)


class WeightTypeConverter {
    @TypeConverter
    fun fromString(value: String?): Weight? = value?.split(" ")
        ?.let { (value, unit) ->
            Weight(
                value.toInt(),
                when (unit) {
                    "kg" -> WeightUnit.KILOGRAMS
                    "lb" -> WeightUnit.POUNDS
                    else -> throw IllegalArgumentException("Unknown weight unit: $unit")
                }
            )
        }

    @TypeConverter
    fun typeToString(type: Weight?): String? = type?.run { "$value $unit" }
}
