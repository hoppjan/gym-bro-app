package de.janhopp.gymbro.db.model.planning

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import de.janhopp.gymbro.db.model.PersonTable

@Entity(
    foreignKeys = [
        ForeignKey(entity = PersonTable::class, parentColumns = ["id"], childColumns = ["personId"]),
    ]
)
data class WorkoutPlanTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String?,
    val icon: String?,
    val personId: Int,
)
