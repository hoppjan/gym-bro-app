package de.janhopp.gymbro.db.model.execution

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(entity = WorkoutExecutionTable::class, parentColumns = ["id"], childColumns = ["workoutExecutionId"]),
    ]
)
data class ExerciseExecutionTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val index: Int,
    val workoutExecutionId: Int,
)
