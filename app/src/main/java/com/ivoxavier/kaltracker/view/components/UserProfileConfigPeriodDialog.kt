package com.ivoxavier.kaltracker.view.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ivoxavier.kaltracker.view.fragments.ObjectiveList

@Composable
fun UserProfileConfigPeriodDialog(){
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
        ) {
            Text(text = "Define o periodo")
            
            Row {
                RadioButton(selected = false, onClick = { /*TODO*/ })
                Text(text="option1")
            }
            Row {
                RadioButton(selected = false, onClick = { /*TODO*/ })
                Text(text="option2")
            }
            Row {
                RadioButton(selected = false, onClick = { /*TODO*/ })
                Text(text="option3")
            }
            Row {
                RadioButton(selected = false, onClick = { /*TODO*/ })
                Text(text="option4")
            }
            Button(onClick = {

            }) {
                Text("Fechar")
            }
        }
    }
}