package com.ivoxavier.kaltracker.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun HomeIndicatorsProgress(title: String, progress: Float, max: Int) {
    Column(modifier = Modifier.width(100.dp),

        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            fontSize = 16.sp,
           // modifier = Modifier.width(80.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .height(20.dp)
                //.fillMaxWidth(0.8f)
                .width(100.dp)
                .background(Color.LightGray, RoundedCornerShape(10.dp))
        ) {
            LinearProgressIndicator(
                progress = { progress / max },
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
            )

        }
    }
}