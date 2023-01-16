package com.example.roomapp1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
/*
    * The @Database annotation includes the following parameters:
    * entities: An array of classes that are entities in the database.
    * version: The current version of the database.
    * exportSchema: A boolean that determines whether to export the schema.

 */
@Database(entities = [User::class], version = 3, exportSchema = false)

/*
    * The RoomDatabase class is an abstract class that represents the database.
    * The class must be abstract and extend RoomDatabase.
    * The class must be annotated with @Database.
    * The class must include an abstract method that has 0 arguments and returns the class that is annotated with @Dao.
    * The class must be a singleton to prevent having multiple instances of the database opened at the same time.
    * The class must be initialized in the Application class to prevent having multiple instances of the database opened at the same time.
    *
 */
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        // The getInstance() method returns the singleton.
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "my_database.db")
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }

}
