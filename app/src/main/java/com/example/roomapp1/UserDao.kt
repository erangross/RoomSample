package com.example.roomapp1

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getById(id: Int): User

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}
