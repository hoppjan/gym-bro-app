package de.janhopp.gymbro.db.model.planning

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutPlanTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String?,
    val icon: String?,
)
