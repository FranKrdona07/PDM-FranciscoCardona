package com.example.labo4.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.labo4.model.Task
import androidx.compose.ui.tooling.preview.Preview
import java.util.Date
@Composable
fun TaskCard(
    task: Task,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Título: " + task.title,
                style = MaterialTheme.typography.titleMedium
            )

            if (task.description.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Descripción: " + task.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = "Fecha: " + task.endDate.toString()
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TaskCardPreview() {
    val dummyTask = Task(
        id = 1,
        title = "Aprender MVVM",
        description = "Terminar el laboratorio 4 de Android",
        endDate = Date(),
        isCompleted = false
    )
    TaskCard(task = dummyTask)
}