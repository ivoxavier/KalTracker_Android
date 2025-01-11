package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.model.Product
import com.ivoxavier.kaltracker.service.repository.model.UserFoodsListModel
import com.ivoxavier.kaltracker.view.components.ListItemDivider
import com.ivoxavier.kaltracker.view.components.ListItemHeader
import com.ivoxavier.kaltracker.view.components.ListItemVerticalSpacer
import com.ivoxavier.kaltracker.viewmodel.IngestionConfigViewModel

class IngestionConfigActivity : ComponentActivity() {

    lateinit var viewModel: IngestionConfigViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[IngestionConfigViewModel::class.java]

        // Recebe os dados do produto da Intent
        val product = intent.getSerializableExtra("product") as? Product
        viewModel.setProduct(product)

        // Recebe a lista de produtos da Intent lista
        val products = intent.getSerializableExtra("products") as? ArrayList<UserFoodsListModel>
        viewModel.setUserFoodsList(products)

        val productIndex = intent.getIntExtra("productIndex", -1) // -1 como valor padrão se não for encontrado
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
                // TODO: Ação ao clicar no botão
            }) {
                Icon(Icons.Filled.Check, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            item {
                ListItemHeader(title = stringResource(id = R.string.ingestion_config_header_title))
                ListItemVerticalSpacer()
                if(productScanned != null){
                    Text("Nome: ${productScanned?.productName}")
                    Text("Calorias: ${productScanned?.nutriments?.energyValue}")
                }
                else{
                    Text("Nome: ${userFoodsListIndex?.let { userFoodsList?.get(it)?.name }}")
                    Text("Calorias: ${userFoodsListIndex?.let { userFoodsList?.get(it)?.cal }}")
                }
                //Text("Carboidrato: 123")
                //Text("Proteina: 123")
                //Text("Gordura: 123")
                ListItemVerticalSpacer()
                ListItemDivider()
                ListItemHeader("Tamanho da Porção")
                ListItemHeader("Qunrity")

            }
            // TODO: Adicione mais itens aqui
        }
    }
}