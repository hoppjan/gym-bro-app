package de.janhopp.gymbro.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class UserRepository(database: Database) {
    private val userQueries = database.userQueries

    fun selectAll(): Flow<List<User>> =
        userQueries.selectAll().asFlow().mapToList(Dispatchers.IO)

    fun findById(id: Long): Flow<User?> =
        userQueries.findById(id).asFlow().map(Query<User>::executeAsOneOrNull)

    fun findByName(username: String): Flow<User?> =
        userQueries.findByName(username).asFlow().map(Query<User>::executeAsOneOrNull)

    suspend fun insert(user: User) = withContext(Dispatchers.IO) {
        userQueries.insert(user)
    }

    suspend fun insertUser(id: Long, username: String) = withContext(Dispatchers.IO) {
        userQueries.insertUser(id, username)
    }
}
