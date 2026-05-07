package com.fjcm4.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PantallaHome(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Seleccione una opcion",
            modifier = Modifier.padding(bottom = 24.dp),
            color = Color.Blue,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = { navController.navigate("listado") },
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Icon(Icons.Default.List, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Ver la lista de nombres")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("sensores") },
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Icon(Icons.Default.Info, contentDescription = "Info de sensor de luz")
            Spacer(Modifier.width(8.dp))
            Text("Ver información de sensores")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaHomePreview() {
    val navController = rememberNavController()
    com.fjcm4.myapplication.ui.theme.MyApplicationTheme {
        PantallaHome(navController)
    }
}