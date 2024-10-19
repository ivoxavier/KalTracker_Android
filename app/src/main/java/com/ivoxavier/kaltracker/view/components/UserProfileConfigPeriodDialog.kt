package com.ivoxavier.kaltracker.view.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.view.fragments.ObjectiveList
import com.ivoxavier.kaltracker.viewmodel.UserProfileConfigViewModel

@Composable
fun UserProfileConfigPeriodDialog(dialogHeader: String, viewModel: UserProfileConfigViewModel){
    val context = LocalContext.current
    var selectedOption by remember { mutableStateOf(0) } //
    Dialog(onDismissRequest = { viewModel.hideDialog() }) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
        ) {
            Text(text = dialogHeader,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                fontSize = 24.sp
                )

            Text(text = context.getString(R.string.user_config_profile_dialog_safety_period_warning),
                modifier = Modifier
                    .padding(16.dp))
            
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Text(text=context.getString(R.string.user_config_profile_dialog_period_one),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                )
                RadioButton(selected = selectedOption == 1, onClick = {
                    viewModel.setPeriodPlan(selectedPeriod = 1)
                    selectedOption = 1
                    })
            }
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Text(text=context.getString(R.string.user_config_profile_dialog_period_two),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                )
                RadioButton(selected = selectedOption == 2, onClick = {
                    viewModel.setPeriodPlan(selectedPeriod = 2)
                    selectedOption = 2
                })
            }
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Text(text=context.getString(R.string.user_config_profile_dialog_period_three),
                    modifier = Modifier.weight(1f)
                        .padding(start = 16.dp)
                )
                RadioButton(selected = selectedOption == 3, onClick = {
                    viewModel.setPeriodPlan(selectedPeriod = 3)
                    selectedOption = 3
                })
            }
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Text(text=context.getString(R.string.user_config_profile_dialog_period_four),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                )
                RadioButton(selected = selectedOption == 4, onClick = {
                    viewModel.setPeriodPlan(selectedPeriod = 4)
                    selectedOption = 4
                })
            }
        }
    }
}