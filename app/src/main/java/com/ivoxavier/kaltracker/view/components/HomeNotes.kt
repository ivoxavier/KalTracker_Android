package com.ivoxavier.kaltracker.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ivoxavier.kaltracker.R

@Composable
fun HomeNotes(){
    Image(painter = painterResource(id = R.drawable.ic_baseline_attach_file_24),
        contentDescription = null)
}