package de.janhopp.gymbro.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.janhopp.gymbro.db.model.ExerciseTypeConverter
import de.janhopp.gymbro.db.model.PersonTable
import de.janhopp.gymbro.db.model.planning.WorkoutPlanTable
import de.janhopp.gymbro.model.exercise.WeightTypeConverter
import de.janhopp.gymbro.model.planning.ExerciseTable

@Database(
    entities = [
        ExerciseTable::class,
        WorkoutPlanTable::class,
        PersonTable::class
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
