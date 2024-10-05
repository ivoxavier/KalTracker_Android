package com.ivoxavier.kaltracker.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivoxavier.kaltracker.viewmodel.UserProfileConfigViewModel

@Composable
fun UserProfileConfigBodyMeasureText(type: String, unitLabel: String, hint: String){
    val viewModel = viewModel<UserProfileConfigViewModel>()
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){
        TextField(
            modifier = Modifier.fillMaxHeight()
                .fillMaxWidth()
                .padding(16.dp),
            value = text,
            onValueChange = { newText ->
                text = newText
                if(type == "HEIGHT"){
                    viewModel.setHeight(newText.text.toInt())
                }else{
                    viewModel.setWeight(newText.text.toInt())
                }
            },
            singleLine = true,
            placeholder = { Text(text = hint) }
        )
    }
}