package com.ivoxavier.kaltracker.view.fragments

import android.content.Context
import android.content.Intent
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
import androidx.core.content.ContextCompat.startActivity
import com.ivoxavier.kaltracker.service.repository.model.UserModel
import com.ivoxavier.kaltracker.view.HomeActivity
import kotlinx.coroutines.delay


class BodyMeasureFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val viewModel = viewModel<UserProfileConfigViewModel>(viewModelStoreOwner = requireActivity())
                BodyMeasureList(viewModel){
            }
        }
    }
}

@Composable
fun BodyMeasureList(viewModel:UserProfileConfigViewModel, onCalculate: () -> Unit){
    val context = LocalContext.current

    LazyColumn{
        items(1){
            UserProfileConfigHeaderText(headerText = context.getString(R.string.user_config_profile_header_body_measure_text))
            UserProfileConfigBodyMeasureText(viewModel,type = "HEIGHT", unitLabel = "cm", hint= context.getString(R.string.user_config_profile_placeholder_height_measure_text))
            UserProfileConfigBodyMeasureText(viewModel,type = "WEIGHT", unitLabel = "kg", hint= context.getString(R.string.user_config_profile_placeholder_weight_measure_text))
            Row(modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
            }
        }
    }
    ConfirmCalories(viewModel)
}


@Composable
fun ConfirmCalories(viewModel: UserProfileConfigViewModel){
    val context = LocalContext.current
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
            title ={Text(text = context.getString(R.string.user_config_profile_dialog_recommended_calories))} ,
            text = {Text(text = viewModel.recommendedCalories().toString(),
                fontSize = 20.sp)},
            onDismissRequest = { showDialog = false },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text(context.getString(R.string.user_config_profile_dialog_recommended_calories_go_back))
                }
            },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    val model = UserModel().apply {
                        this.age = viewModel.age.value!!
                        this.sex_at_birth = viewModel.sex_at_birth.value!!
                        this.weight = viewModel.weight.value!!.toDouble()
                        this.height = viewModel.height.value!!.toDouble()
                        this.activity = viewModel.activity.value!!
                        this.rec_cal = viewModel.recommendedCalories()
                    }
                    viewModel.save(model)
                    val appSettings = context.getSharedPreferences("appsettings", Context.MODE_PRIVATE)
                    appSettings.edit().putBoolean("IS_CLEAN_INSTALL", false).apply()
                    context.startActivity(Intent(context, HomeActivity::class.java))

                //finish() create a val in viewModel an finish() from ClassActivity?

                }) {
                    Text(context.getString(R.string.user_config_profile_dialog_recommended_calories_continue))
                }
            })
        }
    }
}