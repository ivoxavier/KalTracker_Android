package com.ivoxavier.kaltracker.view

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModelProvider
import com.ivoxavier.kaltracker.viewmodel.QuickAdditionViewModel
import com.ivoxavier.kaltracker.viewmodel.QuickListFoodsViewModel

class QuickListFoodsActivity: ComponentActivity() {

    //we need both viewModels since this activity fetch foods from DB and has a button to open QuickAdditionActivity
    lateinit var viewModel: QuickListFoodsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[QuickListFoodsViewModel::class.java]

        val mealCategory = intent.getIntExtra("mealCategory", -1)
        viewModel.mealCategory = mealCategory

        setContent {
             ProductList(viewModel,mealCategory)
        }
    }
}

@Composable
fun ProductList(viewModel: QuickListFoodsViewModel, mealCategory: Int){
    val products = viewModel.products.observeAsState(initial = emptyList())
    val context = LocalContext.current
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val intent = Intent(context, QuickAdditionActivity::class.java)
                intent.putExtra("mealCategory", mealCategory)
                context.startActivity(intent)
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(products.value) {product ->
                Text(text = product.name)
                //Text(text = if (mealCategory.toString() == "0") "Breakfast" else if (mealCategory.toString() == "1") "Lunch" else if (mealCategory.toString() == "2") "Dinner" else "Snacks")

            }
        }
    }
}

