package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

                item{
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Card(modifier = Modifier
                            .padding(16.dp)
                            .width(90.dp)
                            .height(90.dp),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 10.dp
                            )
                        ){
                            Image(modifier = Modifier
                                .fillMaxSize(),
                                    painter = painterResource(id = R.drawable.logo_kaltracker),
                                contentDescription = null)
                        }
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "Version: 1.10.0")
                    }
                }

                item{
                Spacer(modifier = Modifier.height(16.dp))
                }

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

                item{
                    Spacer(modifier = Modifier.height(16.dp))
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
                
                item{
                    Spacer(modifier = Modifier.height(16.dp))
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



