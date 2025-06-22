package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.execution.SetTable

@Dao
interface SetDao {
    @Insert
    fun insert(set: SetTable)

    @Query("SELECT * FROM SetTable")
    fun getAll(): List<SetTable>

    @Query("SELECT * FROM SetTable WHERE id = :id")
    fun getById(id: Int): SetTable

    @Query("SELECT * FROM SetTable WHERE exerciseExecutionId = :exerciseExecutionId")
    fun getByExerciseId(exerciseExecutionId: Int): List<SetTable>

    @Update
    fun update(set: SetTable)

    @Delete
    fun delete(set: SetTable)
}
