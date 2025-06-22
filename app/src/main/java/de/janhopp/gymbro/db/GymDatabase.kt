package de.janhopp.gymbro.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.janhopp.gymbro.db.model.ExerciseTypeConverter
import de.janhopp.gymbro.db.model.PersonTable
import de.janhopp.gymbro.db.model.execution.ExerciseExecutionTable
import de.janhopp.gymbro.db.model.execution.SetTable
import de.janhopp.gymbro.db.model.execution.WorkoutExecutionTable
import de.janhopp.gymbro.db.model.planning.PlannedExerciseTable
import de.janhopp.gymbro.db.model.planning.WorkoutPlanTable
import de.janhopp.gymbro.model.exercise.WeightTypeConverter

@Database(
    entities = [
        PersonTable::class,
        WorkoutPlanTable::class,
        PlannedExerciseTable::class,
        ExerciseExecutionTable::class,
        SetTable::class,
        WorkoutExecutionTable::class,
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(
    ExerciseTypeConverter::class,
    WeightTypeConverter::class
)
abstract class GymDatabase : RoomDatabase() {
}
