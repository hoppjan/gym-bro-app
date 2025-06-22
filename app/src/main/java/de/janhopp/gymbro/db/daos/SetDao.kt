package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.execution.SetTable
import kotlinx.coroutines.flow.Flow

@Dao
interface SetDao {
    @Insert
    suspend fun insert(set: SetTable)

    @Query("SELECT * FROM SetTable")
    fun getAll(): Flow<List<SetTable>>

    @Query("SELECT * FROM SetTable WHERE id = :id")
    fun getById(id: Int): Flow<SetTable>

    @Query("SELECT * FROM SetTable WHERE exerciseExecutionId = :exerciseExecutionId")
    fun getByExerciseId(exerciseExecutionId: Int): Flow<List<SetTable>>

    @Update
    suspend fun update(set: SetTable)

    @Delete
    suspend fun delete(set: SetTable)
}
