package de.janhopp.gymbro.db.model.planning

import androidx.room.Entity

@Entity
data class PlannedExerciseTable(
    val name: String,
    val index: Int,
    val pauseInBetween: Int,
    val pauseAfterwards: Int,
    val description: String?,
    val equipment: String?,
    val muscleGroup: String?,
)
