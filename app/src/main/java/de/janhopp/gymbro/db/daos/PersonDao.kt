package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.PersonTable
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Insert
    suspend fun insert(person: PersonTable)

    @Query("SELECT * FROM persontable")
    fun getAll(): Flow<List<PersonTable>>

    @Query("SELECT * FROM persontable WHERE id = :id")
    fun getById(id: Int): Flow<PersonTable>

    @Query("SELECT * FROM persontable WHERE name = :name")
    fun getByName(name: String): Flow<PersonTable>

    @Query("SELECT * FROM persontable LIMIT 1")
    fun getFirst(): Flow<PersonTable>

    @Update
    suspend fun update(person: PersonTable)

    @Delete
    suspend fun delete(person: PersonTable)
}
