package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ivoxavier.kaltracker.ui.theme.KalTrackerTheme

class HomeActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent{
            LazyColumn{
                items(1){
                    Greeting("HomeActivity, yay")
                }
            }

        }
    }
}

@Composable
fun Greeting(s: String) {
    Text(text = "Hello $s!")
}
