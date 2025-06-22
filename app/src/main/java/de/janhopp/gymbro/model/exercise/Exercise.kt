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
    val duration: Duration,
) : Exercise

fun ExerciseTable.toExercise(): Exercise = when (type) {
    ExerciseType.WEIGHT ->
        WeightExercise(id, name, description, equipment, muscleGroup, sets!!, reps!!, weight!!)
    ExerciseType.BODY_WEIGHT ->
        BodyWeightExercise(id, name, description, equipment, muscleGroup, sets!!, reps!!)
    ExerciseType.CARDIO ->
        CardioExercise(id, name, description, equipment, muscleGroup, duration!!)
}

fun Exercise.toExerciseTable(): ExerciseTable = when (this) {
    is WeightExercise ->
        ExerciseTable(id, ExerciseType.WEIGHT, name, description, equipment, muscleGroup, sets, reps, weight = weight, duration = null)
    is BodyWeightExercise ->
        ExerciseTable(id, ExerciseType.BODY_WEIGHT, name, description, equipment, muscleGroup, sets, reps, weight = null, duration = null)
    is CardioExercise ->
        ExerciseTable(id, ExerciseType.CARDIO, name, description, equipment, muscleGroup, sets = null, reps = null, weight = null, duration = null)
}
