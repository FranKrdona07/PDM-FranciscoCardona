package com.example.labo4.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.labo4.data.TaskDatabase
import com.example.labo4.data.TaskRepository
import com.example.labo4.model.Task
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GeneralViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = TaskRepository(
        TaskDatabase.getDatabase(application).taskDao()
    )

    val tasks: StateFlow<List<Task>> = repository.tasks
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            repository.addTask(title, description)
        }
    }
}
