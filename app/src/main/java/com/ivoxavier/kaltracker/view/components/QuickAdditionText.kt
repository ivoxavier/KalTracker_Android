package com.ivoxavier.kaltracker.view.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants
import com.ivoxavier.kaltracker.viewmodel.QuickAdditionViewModel

@Composable
fun QuickAdditionText(viewModel: QuickAdditionViewModel, label:String, input:String,onProductNameChange: (String) -> Unit = {}){
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
            onValueChange = { newText ->
                text = newText
                if((input == KalTrackerConstants.QUICK_ADDITION.PRODUCT_NAME) && newText.text.isNotEmpty()){
                    onProductNameChange(newText.text)
                    viewModel.setProductName(newText.text)
                }else if ((input == KalTrackerConstants.QUICK_ADDITION.PRODUCT_CALORIES) && newText.text.isNotEmpty() ){
                    viewModel.setProductCalories(newText.text.toInt())
                } else{
                    if(newText.text.matches(Regex("^[0-9]+(\\.[0-9]+)?\$"))){
                        viewModel.setFat(newText.text.toDouble())
                        viewModel.setCarbo(newText.text.toDouble())
                        viewModel.setProtein(newText.text.toDouble())
                    }

                }
                            },
            //label = {Text(text= stringResource(id = R.string.quick_addition_product_name))}
            label = {Text(modifier = Modifier.padding(0.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                text= label)},
            keyboardOptions = KeyboardOptions(
                keyboardType = if (input == KalTrackerConstants.QUICK_ADDITION.PRODUCT_NAME){
                    KeyboardType.Text
                }else {
                    //KalTrackerConstants.QUICK_ADDITION.PRODUCT_CALORIES
                    KeyboardType.Number
                }
            ),
            singleLine = true
        )
    }
}