package com.ivoxavier.kaltracker.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
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
                BodyMeasureList()
            }
        }
    }
}

@Composable
fun BodyMeasureList(){
    val viewModel = viewModel<UserProfileConfigViewModel>()
    val context = LocalContext.current
    var textd: String = ""
    fun calculate(){
       textd = viewModel.calories.toString()
    }

    LazyColumn{
        items(1){
            UserProfileConfigHeaderText(headerText = context.getString(R.string.user_config_profile_header_body_measure_text))
            UserProfileConfigBodyMeasureText(type = "HEIGHT", unitLabel = "cm", hint= context.getString(R.string.user_config_profile_placeholder_height_measure_text))
            UserProfileConfigBodyMeasureText(type = "HEIGHT", unitLabel = "kg", hint= context.getString(R.string.user_config_profile_placeholder_weight_measure_text))
            Text(text = textd, color = androidx.compose.ui.graphics.Color.White, fontSize = 20.sp)
            Button(onClick = { calculate() }) {

            }
        }
    }

}