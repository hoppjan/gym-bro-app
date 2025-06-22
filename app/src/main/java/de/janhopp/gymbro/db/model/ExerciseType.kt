package de.janhopp.gymbro.db.model

import androidx.room.TypeConverter

enum class ExerciseType {
    WEIGHT,
    BODY_WEIGHT,
    CARDIO,
}

class ExerciseTypeConverter {
    @TypeConverter
    fun fromString(value: String?): ExerciseType? =
        value?.let { ExerciseType.valueOf(it) }

    @TypeConverter
    fun typeToString(type: ExerciseType?): String? = type?.toString()
}