package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ivoxavier.kaltracker.view.components.ListItemDivider
import com.ivoxavier.kaltracker.view.components.ListItemHeader
import com.ivoxavier.kaltracker.view.components.ListItemVerticalSpacer

class IngestionConfigActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IngestionConfig()
        }
    }
}

@Composable
fun IngestionConfig(){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // TODO: Ação ao clicar no botão
            }) {
                Icon(Icons.Filled.Check, contentDescription = "Add")
            }
        }
    ) { innerPadding -> // Adicione innerPadding aqui
        LazyColumn(contentPadding = innerPadding) { // Use innerPadding para o LazyColumn
            item {
                ListItemHeader(title = "Pao com manteiga")
                ListItemVerticalSpacer()
                Text("Calorias: 123")
                Text("Carboidrato: 123")
                Text("Proteina: 123")
                Text("Gordura: 123")
                ListItemVerticalSpacer()
                ListItemDivider()
                ListItemHeader("Tamanho da Porção")
            }
            // TODO: Adicione mais itens aqui
        }
    }
}