package com.ivoxavier.kaltracker.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.runtime.setValue
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.view.components.UserProfileConfigBodyMeasureText
import com.ivoxavier.kaltracker.view.components.UserProfileConfigHeaderText
import com.ivoxavier.kaltracker.viewmodel.UserProfileConfigViewModel

class BodyMeasureFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val viewModel = viewModel<UserProfileConfigViewModel>()
                var currentText by remember { mutableStateOf("") }
                BodyMeasureList(textd = currentText){
                    currentText = viewModel.recommendedCalories().toString()
                }
            }
        }
    }
}

@Composable
fun BodyMeasureList(textd: String, onCalculate: () -> Unit){
    val viewModel = viewModel<UserProfileConfigViewModel>()
    val context = LocalContext.current

    LazyColumn{
        items(1){
            UserProfileConfigHeaderText(headerText = context.getString(R.string.user_config_profile_header_body_measure_text))
            UserProfileConfigBodyMeasureText(type = "HEIGHT", unitLabel = "cm", hint= context.getString(R.string.user_config_profile_placeholder_height_measure_text))
            UserProfileConfigBodyMeasureText(type = "WEIGHT", unitLabel = "kg", hint= context.getString(R.string.user_config_profile_placeholder_weight_measure_text))
            Row(modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text(text = textd, color = androidx.compose.ui.graphics.Color.White, fontSize = 20.sp)
            }

            Button(onClick = onCalculate) {
                Text(text = "Calculate")
            }
        }
    }

}