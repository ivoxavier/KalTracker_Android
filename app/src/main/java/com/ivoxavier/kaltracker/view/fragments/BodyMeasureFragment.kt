package com.ivoxavier.kaltracker.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.view.components.UserProfileConfigBodyMeasureText
import com.ivoxavier.kaltracker.view.components.UserProfileConfigHeaderText
import com.ivoxavier.kaltracker.viewmodel.UserProfileConfigViewModel
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay


var calories_text : String = ""

class BodyMeasureFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val viewModel = viewModel<UserProfileConfigViewModel>(viewModelStoreOwner = requireActivity())
                //var calories_text by remember { mutableStateOf("") }
                BodyMeasureList(viewModel,textd = calories_text){
                    //calories_text = viewModel.recommendedCalories().toString()
                    if(calories_text == "0"){
                        Toast.makeText(context, "Error calculating calories", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

@Composable
fun BodyMeasureList(viewModel:UserProfileConfigViewModel,textd: String, onCalculate: () -> Unit){
    val context = LocalContext.current

    LazyColumn{
        items(1){
            UserProfileConfigHeaderText(headerText = context.getString(R.string.user_config_profile_header_body_measure_text))
            UserProfileConfigBodyMeasureText(viewModel,type = "HEIGHT", unitLabel = "cm", hint= context.getString(R.string.user_config_profile_placeholder_height_measure_text))
            UserProfileConfigBodyMeasureText(viewModel,type = "WEIGHT", unitLabel = "kg", hint= context.getString(R.string.user_config_profile_placeholder_weight_measure_text))
            Row(modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                //Text(text = textd, color = androidx.compose.ui.graphics.Color.White, fontSize = 20.sp)
            }

            /*Button(onClick = onCalculate) {
                Text(text = "Calculate")
            }*/
        }
    }
    ConfirmCalories(viewModel)
}


@Composable
fun ConfirmCalories(viewModel: UserProfileConfigViewModel){
    var showDialog by remember { mutableStateOf(false) }
    var allSet by remember { mutableStateOf(viewModel.allFieldsFilled(viewModel._allSet)) }

    // check allSet every second
    LaunchedEffect(key1 = Unit) { // Trigger the effect once
        while (true) {
            allSet = viewModel.allFieldsFilled(viewModel._allSet)
            delay(1000) // Wait for 1 second
        }
    }

    if(allSet){
        Box(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(onClick = {
                showDialog = true
            }) {
                androidx.compose.material3.Icon(imageVector = Icons.Rounded.Check, contentDescription ="Add" )
            }
        }
    }

    if(showDialog){
        AlertDialog(
            title ={Text(text ="Recommended Calories")} ,
            text = {Text(text = viewModel.recommendedCalories().toString(),
                fontSize = 20.sp)},
            onDismissRequest = { showDialog = false },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Get Back")
                }
            },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Continue")
                }

            })
    }

}