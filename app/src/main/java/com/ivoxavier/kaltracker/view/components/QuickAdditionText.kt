package com.ivoxavier.kaltracker.view.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants
import com.ivoxavier.kaltracker.viewmodel.QuickAdditionViewModel

@Composable
fun QuickAdditionText(viewModel: QuickAdditionViewModel, label:String, input:String){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(60.dp),
            value = text,
            onValueChange = {
                if(input == KalTrackerConstants.QUICK_ADDITION.PRODUCT_NAME){
                    if(it.text.isNotEmpty()){
                        viewModel.setProductName(it.text)
                    }
                    else{
                        Toast.makeText(context,context.getString(R.string.user_config_profile_body_measure_toast_text), Toast.LENGTH_SHORT).show()
                    }
                }else{
                    //KalTrackerConstants.QUICK_ADDITION.PRODUCT_CALORIES
                    if(it.text.isNotEmpty()){
                        viewModel.setProductCalories(it.text.toInt())
                    }
                    else{
                        Toast.makeText(context,context.getString(R.string.user_config_profile_body_measure_toast_text), Toast.LENGTH_SHORT).show()
                    }
                }
                            },
            //label = {Text(text= stringResource(id = R.string.quick_addition_product_name))}
            label = {Text(modifier = Modifier.padding(0.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                text= label)}
        )
    }
}