package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.ui.theme.KalTrackerTheme
import com.ivoxavier.kaltracker.view.components.CaloriesChart
import com.ivoxavier.kaltracker.view.components.HomeIndicatorsProgress
import com.ivoxavier.kaltracker.view.components.HomeIndicatorsTotal
import com.ivoxavier.kaltracker.view.components.HomeIngestionCard
import com.ivoxavier.kaltracker.view.components.HomeNotes

class HomeActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent{
            LazyColumn{
                items(1){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                        .fillMaxWidth()
                        ){
                        Image(painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                            contentDescription = null)
                    }
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        CaloriesChart(150,400)
                    }
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {
                        HomeIndicatorsTotal(
                            title = resources.getString(R.string.global_string_foods),
                            total = 0
                        )
                        Spacer(modifier = Modifier.width(11.dp))
                        HomeNotes()
                        Spacer(modifier = Modifier.width(10.dp))
                        HomeIndicatorsTotal(
                            title = resources.getString(R.string.global_string_consumed),
                            total = 0
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround) {
                        HomeIndicatorsProgress(
                            title = resources.getString(R.string.global_string_fat),
                            progress = 2.0f,
                            max = 20
                        )
                        Spacer(modifier = Modifier.width(11.dp))
                        HomeIndicatorsProgress(
                            title = resources.getString(R.string.global_string_carbo),
                            progress = 2.0f,
                            max = 20
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        HomeIndicatorsProgress(
                            title = resources.getString(R.string.global_string_protein),
                            progress = 2.0f,
                            max = 20
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically){
                        Image(painter = painterResource(id = R.drawable.ic_baseline_calendar_month_24),
                            contentDescription = null)
                        Text(
                            text = "2024-11-24",
                            fontSize = 16.sp
                        )
                    }


                    HomeIngestionCard(
                        image = R.drawable.breakfast_svgrepo_com,
                        title = resources.getString(R.string.home_ingestion_card_breakfast),
                        mealCategory = 0,
                        totalCalories = 0,
                        onClick = {}
                    )
                    HomeIngestionCard(
                        image = R.drawable.fried_chicken_meal_svgrepo_com,
                        title = resources.getString(R.string.home_ingestion_card_lunch),
                        mealCategory = 1,
                        totalCalories = 0,
                        onClick = {}
                    )
                    HomeIngestionCard(
                        image = R.drawable.dinner_svgrepo_com,
                        title = resources.getString(R.string.home_ingestion_card_dinner),
                        mealCategory = 2,
                        totalCalories = 0,
                        onClick = {}
                    )
                    HomeIngestionCard(
                        image = R.drawable.snack_snacks_svgrepo_com,
                        title = resources.getString(R.string.home_ingestion_card_snacks),
                        mealCategory = 3,
                        totalCalories = 0,
                        onClick = {}
                    )
                }
            }
        }
    }
}

