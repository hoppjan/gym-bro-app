package de.janhopp.gymbro.db.model.execution

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import de.janhopp.gymbro.model.exercise.Weight

@Entity(
    foreignKeys = [
        ForeignKey(entity = ExerciseExecutionTable::class, parentColumns = ["id"], childColumns = ["exerciseExecutionId"]),
    ]
)
data class SetTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val index: Int,
    val exerciseExecutionId: Int,
    val reps: Int?,
    val weight: Weight?,
    val duration: Int?,
)
