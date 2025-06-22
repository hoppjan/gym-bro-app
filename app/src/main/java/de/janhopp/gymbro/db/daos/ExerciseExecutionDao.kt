package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.execution.ExerciseExecutionTable

@Dao
interface ExerciseExecutionDao {
    @Insert
    fun insert(exerciseExecution: ExerciseExecutionTable)

    @Query("SELECT * FROM ExerciseExecutionTable")
    fun getAll(): List<ExerciseExecutionTable>

    @Query("SELECT * FROM ExerciseExecutionTable WHERE id = :id")
    fun getById(id: Int): ExerciseExecutionTable

    @Query("SELECT * FROM ExerciseExecutionTable WHERE workoutExecutionId = :workoutExecutionId")
    fun getByWorkoutExecutionId(workoutExecutionId: Int): List<ExerciseExecutionTable>

    @Update
    fun update(exerciseExecution: ExerciseExecutionTable)

    @Delete
    fun delete(exerciseExecution: ExerciseExecutionTable)
}
