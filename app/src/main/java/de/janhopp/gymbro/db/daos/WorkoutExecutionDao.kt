package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.execution.WorkoutExecutionTable

@Dao
interface WorkoutExecutionDao {
    @Insert
    fun insert(workoutExecution: WorkoutExecutionTable)

    @Query("SELECT * FROM WorkoutExecutionTable")
    fun getAll(): List<WorkoutExecutionTable>

    @Query("SELECT * FROM WorkoutExecutionTable WHERE id = :id")
    fun getById(id: Int): WorkoutExecutionTable

    @Update
    fun update(workoutExecution: WorkoutExecutionTable)

    @Delete
    fun delete(workoutExecution: WorkoutExecutionTable)
}
