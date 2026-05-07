package com.fjcm4.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjcm4.myapplication.ui.theme.MyApplicationTheme
import com.fjcm4.myapplication.ui.screens.PantallaHome
import com.fjcm4.myapplication.ui.screens.PantallaListado
import com.fjcm4.myapplication.ui.screens.PantallaSensor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") { PantallaHome(navController) }
                        composable("listado") { PantallaListado(navController) }
                        composable("sensores") { PantallaSensor(navController) }
                    }
                }
            }
        }
    }
}

