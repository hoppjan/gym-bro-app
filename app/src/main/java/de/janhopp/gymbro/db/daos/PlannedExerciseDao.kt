package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.planning.PlannedExerciseTable
import kotlinx.coroutines.flow.Flow

@Dao
interface PlannedExerciseDao {
    @Insert
    suspend fun insert(plannedExercise: PlannedExerciseTable)

    @Query("SELECT * FROM plannedexercisetable")
    fun getAll(): Flow<List<PlannedExerciseTable>>

    @Query("SELECT * FROM plannedexercisetable WHERE type = :type")
    fun getByType(type: String): Flow<List<PlannedExerciseTable>>

    @Query("SELECT * FROM PlannedExerciseTable WHERE id IN (SELECT plannedExerciseId FROM PlannedWorkoutExercisesTable WHERE workoutPlanId = :workoutPlanId) ORDER BY `index` ASC")
    fun getByWorkoutPlanId(workoutPlanId: Int): Flow<List<PlannedExerciseTable>>

    @Update
    suspend fun update(plannedExercise: PlannedExerciseTable)

    @Delete
    suspend fun delete(plannedExercise: PlannedExerciseTable)
}
