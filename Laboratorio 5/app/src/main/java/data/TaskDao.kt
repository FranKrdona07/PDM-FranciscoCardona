package com.example.labo4.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.labo4.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAllTasks(): Flow<List<Task>>

    @Insert
    suspend fun insertTask(task: Task)
}
