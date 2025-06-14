package de.janhopp.gymbro.model.workout

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutRoutine(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val description: String?,
    val emoji: String?,
    //val exercises: List<Exercise> = emptyList(),
)
