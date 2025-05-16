package de.janhopp.gymbro.db

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

fun createDatabase(context: Context): Database =
    Database(AndroidSqliteDriver(Database.Schema, context, "test.db"))
