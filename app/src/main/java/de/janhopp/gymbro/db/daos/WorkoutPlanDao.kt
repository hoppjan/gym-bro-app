package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.planning.WorkoutPlanTable
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutPlanDao {
    @Insert
    suspend fun insert(workoutPlan: WorkoutPlanTable)

    @Query("SELECT * FROM workoutplantable")
    fun getAll(): Flow<List<WorkoutPlanTable>>

    @Query("SELECT * FROM workoutplantable WHERE id = :id")
    fun getById(id: Int): Flow<WorkoutPlanTable>

    @Query("SELECT * FROM workoutplantable WHERE name = :name")
    fun getByName(name: String): Flow<WorkoutPlanTable>

    @Query("SELECT * FROM workoutplantable WHERE personId = :personId")
    fun getByPersonId(personId: Int): Flow<List<WorkoutPlanTable>>

    @Update
    suspend fun update(workoutPlan: WorkoutPlanTable)

    @Delete
    suspend fun delete(workoutPlan: WorkoutPlanTable)
}
