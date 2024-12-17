package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.view.components.ListItem
import com.ivoxavier.kaltracker.view.components.ListItemButton
import com.ivoxavier.kaltracker.view.components.ListItemDivider
import com.ivoxavier.kaltracker.view.components.ListItemHeader
import com.ivoxavier.kaltracker.view.components.ListItemSwitch
import com.ivoxavier.kaltracker.view.components.TopTextHeader

class ManageDataActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                item {
                    TopTextHeader(text = resources.getString(R.string.menu_item_manage_data))
                }
                item {
                    ListItemHeader("Ingestions")
                    ListItemSwitch(text = "Delete Ingestions Automatically",icon = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24))
                }

                item {
                    ListItem(text = "From a Specific date", icon = ImageVector.vectorResource(id = R.drawable.ic_settings_24)) {
                        // TODO: Handle click
                    }

                    ListItem(text = "Today Ingestions", icon = ImageVector.vectorResource(id = R.drawable.ic_settings_24)) {
                        // TODO: Handle click
                    }
                    ListItemButton(text = "Only Today Ingestion",icon = ImageVector.vectorResource(id = R.drawable.ic_account_circle_24),textButton = "Delete")
                    ListItemDivider()
                }

            }

        }
    }

}