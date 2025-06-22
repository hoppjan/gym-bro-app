package de.janhopp.gymbro.db.model.planning

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import de.janhopp.gymbro.db.model.PersonTable

@Entity(
    foreignKeys = [
        ForeignKey(entity = PersonTable::class, parentColumns = ["id"], childColumns = ["personId"]),
        ForeignKey(entity = WorkoutPlanTable::class, parentColumns = ["id"], childColumns = ["workoutPlanId"]),
    ]
)
data class PersonalWorkoutPlansTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val personId: Int,
    val workoutPlanId: Int,
)
