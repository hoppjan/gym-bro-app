package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.planning.WorkoutPlanTable

@Dao
interface WorkoutPlanDao {
    @Insert
    fun insert(workoutPlan: WorkoutPlanTable)

    @Query("SELECT * FROM workoutplantable")
    fun getAll(): List<WorkoutPlanTable>

    @Query("SELECT * FROM workoutplantable WHERE id = :id")
    fun getById(id: Int): WorkoutPlanTable

    @Query("SELECT * FROM workoutplantable WHERE name = :name")
    fun getByName(name: String): WorkoutPlanTable

    @Query("SELECT * FROM workoutplantable WHERE personId = :personId")
    fun getByPersonId(personId: Int): List<WorkoutPlanTable>

    @Update
    fun update(workoutPlan: WorkoutPlanTable)

    @Delete
    fun delete(workoutPlan: WorkoutPlanTable)
}
