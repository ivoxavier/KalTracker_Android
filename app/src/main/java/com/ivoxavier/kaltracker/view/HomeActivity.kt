package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.ui.theme.KalTrackerTheme
import com.ivoxavier.kaltracker.view.components.CaloriesChart
import com.ivoxavier.kaltracker.view.components.HomeIngestionCard

class HomeActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent{
            LazyColumn{
                items(1){
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        CaloriesChart(150,400)
                    }
                    HomeIngestionCard(
                        isSelected = false,
                        type = "",
                        image = R.drawable.shoe_svgrepo_com,
                        label = "Test",
                        onClick = {}
                    )

                }
            }

        }
    }
}

