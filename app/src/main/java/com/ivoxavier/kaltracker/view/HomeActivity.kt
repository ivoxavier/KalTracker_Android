package com.ivoxavier.kaltracker.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.ui.theme.KalTrackerTheme
import com.ivoxavier.kaltracker.view.components.CaloriesChart
import com.ivoxavier.kaltracker.view.components.HomeIndicatorsProgress
import com.ivoxavier.kaltracker.view.components.HomeIndicatorsTotal
import com.ivoxavier.kaltracker.view.components.HomeIngestionCard
import com.ivoxavier.kaltracker.view.components.HomeNotes
import com.ivoxavier.kaltracker.viewmodel.HomeViewModel

class HomeActivity: ComponentActivity() {

    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.setRecommendedCalories()
        viewModel.setBreakFastCalories()
        viewModel.setLunchCalories()
        viewModel.setDinnerCalories()
        viewModel.setSnackCalories()


        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent{
            val recommendedCalories by viewModel.recommendedCalories.observeAsState()

            LazyColumn{
                items(1){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                        .fillMaxWidth()
                        ){
                        IconButton(onClick = {
                                startActivity(Intent(applicationContext, MenuActivity::class.java))
                        }) {

                            Image(painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                                contentDescription = null)
                        }

                    }
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        CaloriesChart(150,recommendedCalories?.toInt() ?: 0)
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
                        //mealCategory = 0,
                        image = R.drawable.breakfast_svgrepo_com,
                        title = resources.getString(R.string.home_ingestion_card_breakfast),
                        totalCalories = viewModel.breakFastCalories.value ?: 0,
                        onClick = {
                            val intent = Intent(applicationContext, QuickListFoodsActivity::class.java)
                            intent.putExtra("mealCategory", 0)
                            startActivity(intent)
                        }
                    )
                    HomeIngestionCard(
                        //mealCategory = 1
                        image = R.drawable.fried_chicken_meal_svgrepo_com,
                        title = resources.getString(R.string.home_ingestion_card_lunch),
                        totalCalories = viewModel.lunchCalories.value ?: 0,
                        onClick = {
                            val intent = Intent(applicationContext, QuickListFoodsActivity::class.java)
                            intent.putExtra("mealCategory", 1)
                            startActivity(intent)
                        }
                    )
                    HomeIngestionCard(
                        //mealCategory = 2
                        image = R.drawable.dinner_svgrepo_com,
                        title = resources.getString(R.string.home_ingestion_card_dinner),
                        totalCalories = viewModel.dinnerCalories.value ?: 0,
                        onClick = {
                            val intent = Intent(applicationContext, QuickListFoodsActivity::class.java)
                            intent.putExtra("mealCategory", 2)
                            startActivity(intent)
                        }
                    )
                    HomeIngestionCard(
                        //mealCategory = 3
                        image = R.drawable.snack_snacks_svgrepo_com,
                        title = resources.getString(R.string.home_ingestion_card_snacks),
                        totalCalories = viewModel.snackCalories.value ?: 0,
                        onClick = {
                            val intent = Intent(applicationContext, QuickListFoodsActivity::class.java)
                            intent.putExtra("mealCategory", 3)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.setRecommendedCalories()
        viewModel.setBreakFastCalories()
        viewModel.setLunchCalories()
        viewModel.setDinnerCalories()
        viewModel.setSnackCalories()

    }
}

