package com.ivoxavier.kaltracker.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserProfileConfigCard(isSelected: Boolean,type: String, image: Int, label: String, onClick: () -> Unit) {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .height(80.dp)
        .clickable {onClick()},
        colors = CardDefaults.cardColors(
           containerColor = if (isSelected) Color.Green else Color.Gray
       )
        ,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    )//Closing Card Parameters
        {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.fillMaxHeight())
            Spacer(modifier = Modifier.padding(horizontal = 8.dp)) // spacing between image and text
            Text(
                text = label,
                fontSize = 20.sp
            )
        }
    }
}