package com.ivoxavier.kaltracker.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment

class BodyMeasureFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Card(
                    modifier = Modifier.padding(16.dp)
                    //elevation = CardElevation(defaultElevation = 4.dp)
                ) {
                    Text(
                        text = "Objetivo: Perder Peso",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}