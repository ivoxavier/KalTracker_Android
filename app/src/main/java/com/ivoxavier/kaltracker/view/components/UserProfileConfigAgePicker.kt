package com.ivoxavier.kaltracker.view.components

import android.view.View
import android.widget.NumberPicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivoxavier.kaltracker.viewmodel.UserProfileConfigViewModel

@Composable
fun UserProfileConfigAgePicker() {
    val viewModel = viewModel<UserProfileConfigViewModel>()
    val age by viewModel.age.observeAsState()

    //horizontal spacing between the buttons
    val spacing = 19.dp

    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Button(onClick = {
            viewModel.ageIncrement()
        } ) {
            Text(text = "+",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.padding(horizontal = spacing))
        Text(
            text = age.toString(),
            fontSize = 28.sp,
            color = androidx.compose.ui.graphics.Color.White
            )
        Spacer(modifier = Modifier.padding(horizontal = spacing))
        Button(onClick = {
                viewModel.ageDecrement()
        } ) {
            Text(text = "-",
                fontSize = 20.sp
            )
        }
    }
}
