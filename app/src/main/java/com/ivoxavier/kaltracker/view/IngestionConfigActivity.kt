package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants
import com.ivoxavier.kaltracker.service.repository.model.Product
import com.ivoxavier.kaltracker.service.repository.model.UserFoodsListModel
import com.ivoxavier.kaltracker.view.components.ListItem
import com.ivoxavier.kaltracker.view.components.ListItemDivider
import com.ivoxavier.kaltracker.view.components.ListItemHeader
import com.ivoxavier.kaltracker.view.components.ListItemVerticalSpacer
import com.ivoxavier.kaltracker.viewmodel.IngestionConfigViewModel

class IngestionConfigActivity : ComponentActivity() {

    lateinit var viewModel: IngestionConfigViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[IngestionConfigViewModel::class.java]


        val product = intent.getSerializableExtra("product") as? Product
        viewModel.setProduct(product)


        val products = intent.getSerializableExtra("products") as? ArrayList<UserFoodsListModel>
        viewModel.setUserFoodsList(products)

        val productIndex = intent.getIntExtra("productIndex", -1)
        viewModel.setProductIndex(productIndex)

        val mealCategory = intent.getIntExtra("mealCategory", -1)
        viewModel.mealCategory = mealCategory

        setContent {
            IngestionConfig(viewModel)
        }
    }
}

@Composable
fun IngestionConfig(viewModel: IngestionConfigViewModel){
    val productScanned by viewModel.product.observeAsState()
    val userFoodsList by viewModel.userFoodsList.observeAsState()
    val userFoodsListIndex by viewModel.productIndex.observeAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // TODO: Accpet Button
            }) {
                Icon(Icons.Filled.Check, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            item {
                ListItemHeader(title = stringResource(id = R.string.ingestion_config_header_title))
                ListItemVerticalSpacer()
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically)
                    {
                        if(productScanned != null){
                            productScanned?.productName?.let {
                                HeaderText(it)
                            }
                            productScanned?.nutriments?.energyValue?.let {
                                HeaderText(stringResource(id = R.string.global_string_calories) + ": $it")
                            }
                        }
                        else{
                            userFoodsListIndex?.let {
                                userFoodsList?.get(it)?.name?.let {
                                    HeaderText(it)
                                }
                            }
                        }
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    ,horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically){
                    userFoodsListIndex?.let {
                            userFoodsList?.get(it)?.cal?.let {
                                HeaderText(stringResource(id=R.string.global_string_calories) + ": " + it).toString()
                         }
                    }
                }

                ListItemVerticalSpacer()

                if(productScanned != null){
                    productScanned?.nutriments?.carbohydrates100g?.let{
                        ListItem(text = stringResource(id = R.string.global_string_carbo)
                                + ": " + it ,icon = Icons.Filled.Check ){}
                    }
                    productScanned?.nutriments?.proteins100g?.let{
                        ListItem(text = stringResource(id = R.string.global_string_carbo)
                                + ": " + it ,icon = Icons.Filled.Check ){}
                    }
                    productScanned?.nutriments?.fat100g?.let{
                        ListItem(text = stringResource(id = R.string.global_string_carbo)
                                + ": " + it ,icon = Icons.Filled.Check ){}
                    }
                } else{
                    userFoodsListIndex?.let {
                        userFoodsList?.get(it)?.carbo?.let{
                            ListItem(text = stringResource(id = R.string.global_string_carbo)
                                    + ": " + it ,icon = Icons.Filled.Check ){}
                        }
                        userFoodsList?.get(it)?.protein?.let{
                            ListItem(text = stringResource(id = R.string.global_string_protein)
                                    + ": " + it ,icon = Icons.Filled.Check ){}
                        }
                        userFoodsList?.get(it)?.fat?.let{
                            ListItem(text = stringResource(id = R.string.global_string_fat)
                                    + ": " + it ,icon = Icons.Filled.Check ){}
                        }
                    }
                }
                ListItemVerticalSpacer()
                ListItemDivider()
                ListItemHeader(stringResource(id=R.string.ingestion_config_size_portion))


                SizePortionList()









                ListItemHeader(stringResource(id=R.string.ingestion_config_quantity))
            }

        }
    }
}




@Composable
fun SizePortionList() {
    var sizePortion by remember { mutableStateOf(0.0) }
    val isListExpanded = remember {
        mutableStateOf(false)
    }

    val itemPostion = remember {
        mutableStateOf(0)
    }

    val sizePortionList = listOf(
        KalTrackerConstants.SIZE_PORTION.FULL_PORTION,
        KalTrackerConstants.SIZE_PORTION.HALF_PORTION,
        KalTrackerConstants.SIZE_PORTION.THIRD_PORTION,
        KalTrackerConstants.SIZE_PORTION.QUARTER_PORTION,
        KalTrackerConstants.SIZE_PORTION.FIFTH_PORTION,
        KalTrackerConstants.SIZE_PORTION.SIXTH_PORTION
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { isListExpanded.value = true }
                    .padding(8.dp)) {
                Text(text = stringResource(id = R.string.ingestion_config_size_portion) + ":")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = sizePortion.toString())
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                    contentDescription = "DropDown Icon"
                )
            }
        }
        DropdownMenu(
            expanded = isListExpanded.value,
            onDismissRequest = { isListExpanded.value = false }
        ) {
            sizePortionList.forEachIndexed { index, sizePortion ->
                DropdownMenuItem(
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = sizePortion.toString())
                        }
                    },
                    onClick = {
                        isListExpanded.value = false
                        //sizePortion = sizePortion.toDouble()
                        itemPostion.value = index
                    }
                )
            }
        }
    }
}





@Composable
fun HeaderText(nutriments: String){
    Text(modifier = Modifier.padding(start = 16.dp),
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        text = nutriments
    )
}