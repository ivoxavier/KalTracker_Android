package com.ivoxavier.kaltracker.view.fragments

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.view.components.UserProfileConfigCard


class ObjectiveFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ObjectiveList()
            }
        }
    }
}


fun test(){

}

//get the list of objectives
@Composable
fun ObjectiveList(){
    LazyColumn {
        items(1){
            UserProfileConfigCard(image = R.drawable.shoe_svgrepo_com, label ="Perder Peso", onClick = { test()})
            UserProfileConfigCard(image = R.drawable.kilograms_justice_svgrepo_com, label ="Manter Peso", onClick = { test()})
        }
    }
}
