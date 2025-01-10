package com.ivoxavier.kaltracker.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.Settings
import com.ivoxavier.kaltracker.service.repository.scanner.BarcodeScanner
import com.ivoxavier.kaltracker.view.components.ListItemFoods
import com.ivoxavier.kaltracker.view.components.ListItemHeader
import com.ivoxavier.kaltracker.viewmodel.QuickListFoodsViewModel
import kotlinx.coroutines.launch
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut


class QuickListFoodsActivity: ComponentActivity() {

    lateinit var viewModel: QuickListFoodsViewModel
    private lateinit var barcodeScanner: BarcodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        barcodeScanner = BarcodeScanner(this)

        viewModel = ViewModelProvider(this)[QuickListFoodsViewModel::class.java]

        val mealCategory = intent.getIntExtra("mealCategory", -1)
        viewModel.mealCategory = mealCategory

        setContent {
            ProductList(viewModel,mealCategory, barcodeScanner)
        }
    }
}


fun startQuickAdditionActivity(context: Context,mealCategory: Int) {
    val intent = Intent(context, QuickAdditionActivity::class.java)
    intent.putExtra("mealCategory", mealCategory)
    context.startActivity(intent)
}


@Composable
fun ProductList(viewModel: QuickListFoodsViewModel, mealCategory: Int, barcodeScanner: BarcodeScanner){
    val context = LocalContext.current
    val products = viewModel.products.observeAsState(initial = emptyList())
    val appSettings = Settings(context)
    var openFoodFactsEnabled by remember { mutableStateOf(appSettings.isOpenFoodsFactsApiEnabled()) }

    val scope = rememberCoroutineScope()
    val barcodeResults = barcodeScanner.barcodeResults.collectAsStateWithLifecycle()

    var showScanFab by remember { mutableStateOf(false) }


    //observe changes on shared preferences
    LaunchedEffect(key1 = Unit) {
        snapshotFlow { appSettings.isOpenFoodsFactsApiEnabled() }
            .collect { newValue ->
                openFoodFactsEnabled = newValue
            }
    }

    Scaffold(
        floatingActionButton = {
            Column(horizontalAlignment = Alignment.End) {
                AnimatedVisibility(
                    visible = showScanFab && openFoodFactsEnabled,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut()
                ) {
                    FloatingActionButton(
                        onClick = {
                            scope.launch {
                                barcodeScanner.startScanning()
                            }
                        },
                        modifier = Modifier.padding(bottom = 20.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_document_scanner_24),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }

                FloatingActionButton(
                    onClick = {
                        if(openFoodFactsEnabled && showScanFab.not()){
                            showScanFab = true
                        }
                        else if(openFoodFactsEnabled && showScanFab){
                            startQuickAdditionActivity(context,mealCategory)
                            showScanFab = !showScanFab
                        }
                        else{
                            startQuickAdditionActivity(context,mealCategory)
                        }
                    }
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(contentPadding = innerPadding) {
                item{
                    ListItemHeader(title = stringResource(id = R.string.quick_foods_lists))
                }
                items(products.value) {product ->
                    ListItemFoods(icon = Icons.Filled.Add, productName = product.name, calories = product.cal.toString()) {
                            //TODO: Open product details
                        val intent = Intent(context, IngestionConfigActivity::class.java)
                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}