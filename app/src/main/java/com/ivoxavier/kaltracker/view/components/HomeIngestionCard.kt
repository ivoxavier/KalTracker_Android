package com.ivoxavier.kaltracker.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ivoxavier.kaltracker.R


@Composable
fun HomeIngestionCard(image: Int, title: String, totalCalories: Int,onClick: () -> Unit) {
    val context = LocalContext.current
    Card(modifier = Modifier
        .padding(19.dp)
        .fillMaxWidth()
        .height(70.dp),
        colors = CardDefaults.cardColors(
            containerColor =  Color.Gray
        )
        ,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    )//Closing Card Parameters
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween)
        {

            Row(verticalAlignment = Alignment.CenterVertically) { // Added a Row for the image and text
                Image(painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                )

                Spacer(modifier = Modifier.padding(horizontal = 8.dp)) // spacing between image and text

                Column (modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = totalCalories.toString() + " " + context.getString(R.string.global_string_calories).lowercase(),
                        fontSize = 16.sp
                    )
                }
                Spacer(Modifier.weight(1f))

                    IconButton(
                        onClick = { onClick() },
                        modifier = Modifier
                            .background(Color.LightGray, CircleShape)
                            .size(32.dp)
                        //.weight(1f) // Added weight to the image
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add",
                            tint = Color.Gray
                        )
                    }
            }
        }
    }
}