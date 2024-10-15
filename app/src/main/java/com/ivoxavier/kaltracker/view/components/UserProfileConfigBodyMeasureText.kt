package com.ivoxavier.kaltracker.view.components

import android.app.Application
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivoxavier.kaltracker.view.UserProfileConfigActivity
import com.ivoxavier.kaltracker.viewmodel.UserProfileConfigViewModel
import com.ivoxavier.kaltracker.viewmodel.UserProfileConfigViewModelFactory

@Composable
fun UserProfileConfigBodyMeasureText(viewModel: UserProfileConfigViewModel,type: String, unitLabel: String, hint: String){
    val context = LocalContext.current
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
                val _newText = newText.text.trim()
                if(type == "HEIGHT"){
                    if(_newText.isNotEmpty()){
                        viewModel.setHeight(newText.text.toInt())
                    }
                    else{
                        Toast.makeText(context,"Enter a value", Toast.LENGTH_SHORT).show()
                    }

                }else{
                    if(_newText.isNotEmpty()){
                        viewModel.setWeight(newText.text.toInt())
                    }
                    else{
                        Toast.makeText(context,"Enter a value",Toast.LENGTH_SHORT).show()
                    }
                }
            },
            singleLine = true,
            placeholder = { Text(text = hint) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}