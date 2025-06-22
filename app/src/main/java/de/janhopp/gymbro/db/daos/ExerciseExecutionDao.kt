package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.execution.ExerciseExecutionTable
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseExecutionDao {
    @Insert
    suspend fun insert(exerciseExecution: ExerciseExecutionTable)

    @Query("SELECT * FROM ExerciseExecutionTable")
    fun getAll(): Flow<List<ExerciseExecutionTable>>

    @Query("SELECT * FROM ExerciseExecutionTable WHERE id = :id")
    fun getById(id: Int): Flow<ExerciseExecutionTable>

    @Query("SELECT * FROM ExerciseExecutionTable WHERE workoutExecutionId = :workoutExecutionId")
    fun getByWorkoutExecutionId(workoutExecutionId: Int): Flow<List<ExerciseExecutionTable>>

    @Update
    suspend fun update(exerciseExecution: ExerciseExecutionTable)

    @Delete
    suspend fun delete(exerciseExecution: ExerciseExecutionTable)
}
