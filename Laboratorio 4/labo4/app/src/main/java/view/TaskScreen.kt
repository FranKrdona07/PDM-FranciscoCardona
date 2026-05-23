package com.example.labo4.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.labo4.model.Task
import com.example.labo4.viewmodel.GeneralViewModel
import androidx.compose.ui.tooling.preview.Preview
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(viewModel: GeneralViewModel) {
    var showDialog by remember { mutableStateOf(false) }
    val tasks = viewModel.tasks.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Tasks list") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Añadir")
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(tasks.value) { task ->
                TaskCard(task)
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        if (showDialog) {
            CreateTask(
                onDismiss = { showDialog = false },
                onTaskCreated = { newTitle, newDescription ->
                    val newTask = Task(
                        id = tasks.value.size + 1,
                        title = newTitle,
                        description = newDescription
                    )
                    viewModel.addTask(newTask)
                    showDialog = false
                }
            )
        }
    }
}

@Composable
fun CreateTask(
    onDismiss: () -> Unit,
    onTaskCreated: (String, String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.Black)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Nueva Tarea",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp),
                color = Color.White
            )

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(modifier = Modifier.padding(bottom = 16.dp)) {
                Button(onClick = { onDismiss() }) { Text("Cerrar") }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { if (title.isNotBlank()) onTaskCreated(title, description) },
                    enabled = title.isNotBlank()
                ) {
                    Text("Crear")
                }
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskScreenPreview() {
    val dummyViewModel = GeneralViewModel()

    TaskScreen(viewModel = dummyViewModel)
}