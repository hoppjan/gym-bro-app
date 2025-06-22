package de.janhopp.gymbro.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.janhopp.gymbro.db.daos.ExerciseExecutionDao
import de.janhopp.gymbro.db.daos.PersonDao
import de.janhopp.gymbro.db.daos.PlannedExerciseDao
import de.janhopp.gymbro.db.daos.SetDao
import de.janhopp.gymbro.db.daos.WorkoutExecutionDao
import de.janhopp.gymbro.db.daos.WorkoutPlanDao
import de.janhopp.gymbro.db.model.ExerciseTypeConverter
import de.janhopp.gymbro.db.model.PersonTable
import de.janhopp.gymbro.db.model.execution.ExerciseExecutionTable
import de.janhopp.gymbro.db.model.execution.SetTable
import de.janhopp.gymbro.db.model.execution.WorkoutExecutionTable
import de.janhopp.gymbro.db.model.planning.PlannedExerciseTable
import de.janhopp.gymbro.db.model.planning.PlannedWorkoutExercisesTable
import de.janhopp.gymbro.db.model.planning.WorkoutPlanTable
import de.janhopp.gymbro.model.exercise.WeightTypeConverter

@Database(
    entities = [
        PersonTable::class,
        WorkoutPlanTable::class,
        PlannedExerciseTable::class,
        PlannedWorkoutExercisesTable::class,
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
    abstract fun personDao(): PersonDao
    abstract fun workoutPlanDao(): WorkoutPlanDao
    abstract fun plannedExerciseDao(): PlannedExerciseDao
    abstract fun workoutExecutionDao(): WorkoutExecutionDao
    abstract fun exerciseExecutionDao(): ExerciseExecutionDao
    abstract fun setDao(): SetDao
}
