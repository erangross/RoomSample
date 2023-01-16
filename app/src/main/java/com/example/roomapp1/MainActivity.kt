package com.example.roomapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.AutoMigration
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Room.databaseBuilder(this, AppDatabase::class.java, "my_database")
            .addMigrations(Migration2To3())
            .build()
            .also { userDao = it.userDao() }


        CoroutineScope(Dispatchers.IO).launch {
            val users = listOf(
                User(id = UUID.randomUUID().toString(), name = "John Doe", age = 30, weight = 80, height = 180),
                User(id = UUID.randomUUID().toString(), name = "Jane Smith", age = 25, weight = 60, height = 160),
                User(id = UUID.randomUUID().toString(), name = "Bob Johnson", age = 35, weight = 90, height = 190)
            )

            for (user in users) {
                userDao.insert(user)
            }

            for (user in userDao.getAll()) {
                Log.d("MainActivity", "User: ${user.name}")
                Log.d("MainActivity", "Age: ${user.age}")
                Log.d("MainActivity", "Id: ${user.id}")
                Log.d("MainActivity", "Weight: ${user.weight}")
                Log.d("MainActivity", "Height: ${user.height}")

            }


        }

    }
}
