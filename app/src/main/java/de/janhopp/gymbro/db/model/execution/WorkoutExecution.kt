package de.janhopp.gymbro.db.model.execution

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutExecution(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val start: Long,
    val finish: Long,
)
