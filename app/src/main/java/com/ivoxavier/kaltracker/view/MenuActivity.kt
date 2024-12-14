package com.ivoxavier.kaltracker.view

import android.content.Intent
import android.content.pm.PackageManager
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
import androidx.lifecycle.ViewModelProvider
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.view.components.ListItem
import com.ivoxavier.kaltracker.view.components.ListItemDivider
import com.ivoxavier.kaltracker.view.components.ListItemHeader
import com.ivoxavier.kaltracker.view.components.ListItemVerticalSpacer
import com.ivoxavier.kaltracker.viewmodel.MenuViewModel


class MenuActivity:ComponentActivity() {

    private lateinit var viewModel: MenuViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]


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
                        Text(text = resources.getString(R.string.menu_item_app_version) + " " + viewModel.getAppVersion() )
                    }
                }

                item{
                    ListItemVerticalSpacer()
                }

                item {
                    ListItemHeader(resources.getString(R.string.menu_item_user))
                    ListItem(text = resources.getString(R.string.menu_item_your_profile), icon = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24)) {
                        val intent = Intent(applicationContext, UserProfileConfigActivity::class.java)
                        intent.putExtra("isUpdateMode", true)
                        startActivity(intent)
                    }
                    ListItemDivider()
                }

                item {
                    ListItem(text = resources.getString(R.string.menu_item_data_analysis), icon = ImageVector.vectorResource(id = R.drawable.ic_sharp_add_chart_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                }

                item{
                    ListItemVerticalSpacer()
                }

                item {
                    ListItemHeader(resources.getString(R.string.menu_item_settings))
                    ListItem(text = resources.getString(R.string.menu_item_settings), icon = ImageVector.vectorResource(id = R.drawable.ic_settings_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                    ListItem(text = resources.getString(R.string.menu_item_online_sources), icon = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                }
                
                item{
                    ListItemVerticalSpacer()
                }

                item {
                    ListItemHeader(resources.getString(R.string.menu_item_storage))
                    ListItem(text = resources.getString(R.string.menu_item_manage_data), icon = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                    ListItem(text = resources.getString(R.string.menu_item_export_data), icon = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24)) {
                        // TODO: Handle click
                    }
                    ListItemDivider()
                }

            }
        }
    }
}



