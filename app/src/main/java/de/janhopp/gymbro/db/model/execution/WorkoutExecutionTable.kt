package de.janhopp.gymbro.db.model.execution

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import de.janhopp.gymbro.db.model.planning.WorkoutPlanTable

@Entity(
    foreignKeys = [
        ForeignKey(entity = WorkoutPlanTable::class, parentColumns = ["id"], childColumns = ["workoutPlanId"]),
    ]
)
data class WorkoutExecutionTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val start: Long,
    val finish: Long,
    val workoutPlanId: Int,
)
