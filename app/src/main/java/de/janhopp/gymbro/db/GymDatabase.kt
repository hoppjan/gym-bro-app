package de.janhopp.gymbro.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.janhopp.gymbro.model.exercise.DurationTypeConverter
import de.janhopp.gymbro.model.planning.ExerciseTable
import de.janhopp.gymbro.model.planning.ExerciseTypeConverter
import de.janhopp.gymbro.model.exercise.WeightTypeConverter
import de.janhopp.gymbro.model.planning.WorkoutPlan

@Database(
    entities = [
        ExerciseTable::class,
        WorkoutPlan::class,
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(
    DurationTypeConverter::class,
    ExerciseTypeConverter::class,
    WeightTypeConverter::class
)
abstract class GymDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
    abstract fun workoutRoutineDao(): WorkoutRoutineDao
}
