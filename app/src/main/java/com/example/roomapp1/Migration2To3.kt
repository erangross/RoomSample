package com.example.roomapp1

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration2To3 : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // define the necessary changes to the database schema here
        // using the database.execSQL() method
        database.execSQL("ALTER TABLE users ADD COLUMN weight INTEGER NOT NULL DEFAULT 0")
        database.execSQL("ALTER TABLE users ADD COLUMN height INTEGER NOT NULL DEFAULT 0")    }
}
