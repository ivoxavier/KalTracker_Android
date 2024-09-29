package com.ivoxavier.kaltracker.view.components

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun UserProfileConfigCard(image: Int, label: String, onClick: () -> Unit) {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .height(80.dp)
        .clickable {onClick()}) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) { // Use Row for horizontal layout
            Image(painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.fillMaxHeight())
            Spacer(modifier = Modifier.padding(horizontal = 8.dp)) // Add spacing between image and text
            Text(text = label)
        }
    }
}