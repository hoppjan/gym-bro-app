package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.planning.PlannedExerciseTable

@Dao
interface PlannedExerciseDao {
    @Insert
    fun insert(plannedExercise: PlannedExerciseTable)

    @Query("SELECT * FROM plannedexercisetable")
    fun getAll(): List<PlannedExerciseTable>

    @Query("SELECT * FROM plannedexercisetable WHERE type = :type")
    fun getByType(type: String): List<PlannedExerciseTable>

    @Query("SELECT * FROM PlannedExerciseTable WHERE id IN (SELECT plannedExerciseId FROM PlannedWorkoutExercisesTable WHERE workoutPlanId = :workoutPlanId) ORDER BY `index` ASC")
    fun getByWorkoutPlanId(workoutPlanId: Int): List<PlannedExerciseTable>

    @Update
    fun update(plannedExercise: PlannedExerciseTable)

    @Delete
    fun delete(plannedExercise: PlannedExerciseTable)
}
