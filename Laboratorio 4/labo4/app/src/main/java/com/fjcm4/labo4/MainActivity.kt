package com.fjcm4.labo4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labo4.view.TaskScreen
import com.example.labo4.viewmodel.GeneralViewModel
import com.fjcm4.labo4.ui.theme.Labo4Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labo4Theme {
                val navController = rememberNavController()
                val viewModel: GeneralViewModel = viewModel()

                NavHost(navController = navController, startDestination = "task_screen") {
                    composable(route = "task_screen") {
                        TaskScreen(viewModel = viewModel)
                    }
                }
            }
        }
    }
}