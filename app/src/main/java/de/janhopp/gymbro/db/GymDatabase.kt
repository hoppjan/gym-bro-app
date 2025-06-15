package de.janhopp.gymbro.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.janhopp.gymbro.model.exercise.DurationTypeConverter
import de.janhopp.gymbro.model.exercise.ExerciseTable
import de.janhopp.gymbro.model.exercise.ExerciseTypeConverter
import de.janhopp.gymbro.model.exercise.WeightTypeConverter
import de.janhopp.gymbro.model.workout.WorkoutRoutine

@Database(
    entities = [
        ExerciseTable::class,
        WorkoutRoutine::class,
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
