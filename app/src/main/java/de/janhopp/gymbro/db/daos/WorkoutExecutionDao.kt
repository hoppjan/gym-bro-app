package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.execution.WorkoutExecutionTable
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutExecutionDao {
    @Insert
    suspend fun insert(workoutExecution: WorkoutExecutionTable)

    @Query("SELECT * FROM WorkoutExecutionTable")
    fun getAll(): Flow<List<WorkoutExecutionTable>>

    @Query("SELECT * FROM WorkoutExecutionTable WHERE id = :id")
    fun getById(id: Int): Flow<WorkoutExecutionTable>

    @Update
    suspend fun update(workoutExecution: WorkoutExecutionTable)

    @Delete
    suspend fun delete(workoutExecution: WorkoutExecutionTable)
}
