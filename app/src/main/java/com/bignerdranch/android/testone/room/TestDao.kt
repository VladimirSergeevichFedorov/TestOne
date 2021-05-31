package com.bignerdranch.android.testone.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//@Dao
//interface TestDao {
//    @Query("SELECT * FROM task_table")
//    fun getAll(): Flow<List<Test>>
//
//    @Insert
//    suspend fun insertAll(test: List<Test>)
//
//    @Query("DELETE FROM task_table")
//    suspend fun deleteAllTable()
//}