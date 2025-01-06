package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants
import com.ivoxavier.kaltracker.view.components.ListItemHeader
import com.ivoxavier.kaltracker.view.components.ListItemSwitch
import com.ivoxavier.kaltracker.view.components.TopTextHeader


class OnlineSourcesActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appSettings = getSharedPreferences(KalTrackerConstants.APP_SETTINGS.APP_SETTINGS_NAME, MODE_PRIVATE)
            var openFoodFactsEnabled by remember {
                mutableStateOf(appSettings.getBoolean(KalTrackerConstants.APP_SETTINGS.OPEN_FOODS_FACTS_API, false))
            }

            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                item{
                    TopTextHeader(resources.getString(R.string.menu_item_online_sources))
                    ListItemSwitch(
                        text = resources.getString(R.string.online_sources_open_foods_facts_api),
                        icon = ImageVector.vectorResource(id = R.drawable.baseline_online_24),
                        checked = openFoodFactsEnabled,
                        onSwitchChange = { isChecked ->
                            openFoodFactsEnabled = isChecked
                            appSettings.edit().putBoolean(KalTrackerConstants.APP_SETTINGS.OPEN_FOODS_FACTS_API, isChecked).apply()
                        }
                    )
                }

            }
        }
    }
}