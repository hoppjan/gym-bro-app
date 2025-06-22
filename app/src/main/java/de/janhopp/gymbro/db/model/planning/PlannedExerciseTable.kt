package de.janhopp.gymbro.db.model.planning

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlannedExerciseTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val index: Int,
    val pauseInBetween: Int,
    val pauseAfterwards: Int,
    val description: String?,
    val equipment: String?,
    val muscleGroup: String?,
)
