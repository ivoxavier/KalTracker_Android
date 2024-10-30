package com.ivoxavier.kaltracker.view.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CaloriesChart(caloriesMissing: Int, maxCalorires: Int = 2000){
    val sweepAngle = (caloriesMissing.toFloat() / maxCalorires) * 360f
    Box(modifier = Modifier
        .size(200.dp)
        .fillMaxSize()
        .fillMaxWidth()
        .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.size(200.dp)){
            drawArc(
                color = Color.LightGray,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 6f, cap = StrokeCap.Round)
            )
            drawArc(
                color = Color.Green,
                startAngle = -90f,
                sweepAngle = 360f - sweepAngle,
                useCenter = false,
                style = Stroke(width = 6f, cap = StrokeCap.Round)
            )
        }
        // Centralized Text
        Text(
            text = "FALTAM 23 CALORIAS",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}

