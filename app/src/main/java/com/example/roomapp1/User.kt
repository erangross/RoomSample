package com.example.roomapp1

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "users", indices = [Index("id", unique = true)])
data class User(
    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),
    val name: String,
    val age: Int,
    val weight: Int,
    val height: Int
)


