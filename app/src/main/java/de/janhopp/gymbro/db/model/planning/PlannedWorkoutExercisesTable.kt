package de.janhopp.gymbro.db.model.planning

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(entity = WorkoutPlanTable::class, parentColumns = ["id"], childColumns = ["workoutPlanId"]),
        ForeignKey(entity = PlannedExerciseTable::class, parentColumns = ["id"], childColumns = ["plannedExerciseId"]),
    ]
)
data class PlannedWorkoutExercisesTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val workoutPlanId: Int,
    val plannedExerciseId: Int,
    val index: Int,
)
