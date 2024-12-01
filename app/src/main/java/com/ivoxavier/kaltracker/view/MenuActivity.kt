package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.view.components.ListItem
import com.ivoxavier.kaltracker.view.components.ListItemDivider
import com.ivoxavier.kaltracker.view.components.ListItemHeader


class MenuActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)){

                //TODO: put here the icon of the app inside a card with radius

                item {
                    ListItemHeader("User")
                    ListItem(text = "Your Profile", icon = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                }

                item {
                    ListItem(text = "Data Analysis", icon = ImageVector.vectorResource(id = R.drawable.ic_sharp_add_chart_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                }

                item {
                    ListItemHeader("Settings")
                    ListItem(text = "Settings", icon = ImageVector.vectorResource(id = R.drawable.ic_settings_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                    ListItem(text = "Online Sources", icon = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                }

                item {
                    ListItemHeader("Storage")
                    ListItem(text = "Manage Data", icon = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                    ListItem(text = "Export Data", icon = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                }

            }
        }
    }
}
