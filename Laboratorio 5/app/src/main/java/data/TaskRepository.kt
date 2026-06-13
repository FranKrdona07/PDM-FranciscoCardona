package com.example.labo4.data

import com.example.labo4.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {
    val tasks: Flow<List<Task>> = taskDao.getAllTasks()

    suspend fun addTask(title: String, description: String) {
        taskDao.insertTask(
            Task(
                title = title,
                description = description
            )
        )
    }
}
