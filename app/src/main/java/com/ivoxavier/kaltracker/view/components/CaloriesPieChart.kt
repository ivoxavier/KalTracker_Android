package com.ivoxavier.kaltracker.view.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.ivoxavier.kaltracker.R

@Composable
fun CaloriesChart(caloriesMissing: Int, maxCalorires: Int){
    val context = LocalContext.current
    val sweepAngle = (caloriesMissing.toFloat() / maxCalorires.toFloat()) * 360f
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
        Column {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = maxCalorires.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = context.getString(R.string.global_string_calories).uppercase(),
                fontSize = 12.sp
            )
        }

    }
}

