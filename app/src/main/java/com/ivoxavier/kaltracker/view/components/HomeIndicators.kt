package com.ivoxavier.kaltracker.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeIndicatorsTotal(title:String, total: Int){
    Column(modifier = Modifier.width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(modifier = Modifier.align(Alignment.CenterHorizontally),
            text = total.toString(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        Text(modifier = Modifier.align(Alignment.CenterHorizontally),
            text = title,
            fontSize = 17.sp)
    }
}

@Composable
fun HomeIndicatorsProgress(title:String, progress: Float, max: Int){
    Column(modifier = Modifier.width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(modifier = Modifier.align(Alignment.CenterHorizontally),
            text = title,
            fontSize = 20.sp)
        LinearProgressIndicator(
            progress = { progress / max },
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }
}