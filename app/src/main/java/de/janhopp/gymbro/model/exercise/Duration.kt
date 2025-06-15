package de.janhopp.gymbro.model.exercise

import androidx.room.TypeConverter
import kotlin.time.DurationUnit

data class Duration(
    val time: Int,
    val unit: DurationUnit,
)

class DurationTypeConverter {
    @TypeConverter
    fun fromString(value: String?): Duration? =
        value?.split(" ")
            ?.let { (time, unit) -> Duration(time.toInt(), DurationUnit.valueOf(unit)) }

    @TypeConverter
    fun typeToString(type: Duration?): String? = type?.run { "$time $unit" }
}
