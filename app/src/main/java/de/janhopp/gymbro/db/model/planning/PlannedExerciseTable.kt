package de.janhopp.gymbro.db.model.planning

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.janhopp.gymbro.db.model.ExerciseType
import de.janhopp.gymbro.model.exercise.Weight

@Entity
data class PlannedExerciseTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val type: ExerciseType,
    val name: String,
    val index: Int,
    val pauseInBetween: Int,
    val pauseAfterwards: Int,
    val description: String?,
    val equipment: String?,
    val muscleGroup: String?,
    val sets: Int?,
    val reps: Int?,
    val weight: Weight?,
    val duration: Int?,
)
