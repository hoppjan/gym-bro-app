package de.janhopp.gymbro.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import de.janhopp.gymbro.model.workout.WorkoutRoutine

@Dao
interface WorkoutRoutineDao {
    @Query("SELECT * FROM WorkoutRoutine")
    fun getAll(): List<WorkoutRoutine>

    @Query("SELECT * FROM WorkoutRoutine WHERE id = :id")
    fun findById(id: Int): WorkoutRoutine

    @Query("SELECT * FROM WorkoutRoutine WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): WorkoutRoutine

    @Insert
    fun insertAll(vararg users: WorkoutRoutine)

    @Delete
    fun delete(user: WorkoutRoutine)
}
