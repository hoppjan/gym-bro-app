package de.janhopp.gymbro.db

import androidx.room.Database
import androidx.room.RoomDatabase
import de.janhopp.gymbro.model.workout.WorkoutRoutine

@Database(
    entities = [
        WorkoutRoutine::class,
    ],
    version = 1,
)
abstract class GymDatabase : RoomDatabase() {
    abstract fun workoutRoutineDao(): WorkoutRoutineDao
}
