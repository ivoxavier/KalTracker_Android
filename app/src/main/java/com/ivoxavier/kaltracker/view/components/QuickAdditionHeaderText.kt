package com.ivoxavier.kaltracker.view.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun QuickAdditionHeaderText(headerText: String){
    Text(
        text = headerText,
        textAlign = TextAlign.Start,
        fontSize = 32.sp,
        color = androidx.compose.ui.graphics.Color.White
    )
}