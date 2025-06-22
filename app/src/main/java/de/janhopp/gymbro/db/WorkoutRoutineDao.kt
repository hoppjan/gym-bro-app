package de.janhopp.gymbro.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import de.janhopp.gymbro.model.planning.WorkoutPlan
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutRoutineDao {
    @Query("SELECT * FROM WorkoutPlan")
    fun getAll(): Flow<List<WorkoutPlan>>

    @Query("SELECT * FROM WorkoutPlan WHERE id = :id")
    fun findById(id: Int): Flow<WorkoutPlan>

    @Query("SELECT * FROM WorkoutPlan WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Flow<WorkoutPlan>

    @Insert
    suspend fun insertAll(vararg users: WorkoutPlan)

    @Delete
    suspend fun delete(user: WorkoutPlan)
}
