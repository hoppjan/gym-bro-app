package de.janhopp.gymbro.model.exercise

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity
data class ExerciseTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val type: ExerciseType,
    val name: String,
    val description: String?,
    val equipment: String?,
    val muscleGroup: String?,
    val sets: Int?,
    val reps: Int?,
    val weight: Weight?,
    val duration: Duration?,
)

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

sealed interface Exercise {
    val id: Int
    val name: String
    val description: String?
    val equipment: String?
    val muscleGroup: String?
}

data class WeightExercise(
    override val id: Int,
    override val name: String,
    override val description: String?,
    override val equipment: String?,
    override val muscleGroup: String?,
    val sets: Int,
    val reps: Int,
    val weight: Weight,
) : Exercise

@Entity
data class BodyWeightExercise(
    override val id: Int,
    override val name: String,
    override val description: String?,
    override val equipment: String?,
    override val muscleGroup: String?,
    val sets: Int,
    val reps: Int,
) : Exercise

@Entity
data class CardioExercise(
    override val id: Int,
    override val name: String,
    override val description: String?,
    override val equipment: String?,
    override val muscleGroup: String?,
) : Exercise
