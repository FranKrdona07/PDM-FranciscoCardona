package com.fjcm4.myapplication.ui.screens

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PantallaSensor(navController: NavHostController) {
    val context = LocalContext.current
    val sensorManager = remember { context.getSystemService(Context.SENSOR_SERVICE) as? SensorManager }
    val lightSensor = remember { sensorManager?.getDefaultSensor(Sensor.TYPE_LIGHT) }

    var lightValue by remember { mutableFloatStateOf(0f) }

    val sensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            event?.let {
                lightValue = it.values[0]
            }
        }
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    }

    DisposableEffect(lightSensor) {
        if (lightSensor != null) {
            sensorManager?.registerListener(sensorEventListener, lightSensor, SensorManager.SENSOR_DELAY_UI)
        }
        onDispose {
            sensorManager?.unregisterListener(sensorEventListener)
        }
    }

    Scaffold(
        topBar = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sensor de Luz", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Intensidad:${lightValue} lx", fontSize = 18.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PantallaSensoresPreview() {
    val navController = rememberNavController()
    com.fjcm4.myapplication.ui.theme.MyApplicationTheme {
        PantallaSensor(navController)
    }
}