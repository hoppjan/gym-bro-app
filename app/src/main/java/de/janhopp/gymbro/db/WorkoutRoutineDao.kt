package de.janhopp.gymbro.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import de.janhopp.gymbro.model.workout.WorkoutRoutine
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutRoutineDao {
    @Query("SELECT * FROM WorkoutRoutine")
    fun getAll(): Flow<List<WorkoutRoutine>>

    @Query("SELECT * FROM WorkoutRoutine WHERE id = :id")
    fun findById(id: Int): Flow<WorkoutRoutine>

    @Query("SELECT * FROM WorkoutRoutine WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Flow<WorkoutRoutine>

    @Insert
    suspend fun insertAll(vararg users: WorkoutRoutine)

    @Delete
    suspend fun delete(user: WorkoutRoutine)
}
