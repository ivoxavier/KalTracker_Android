package com.ivoxavier.kaltracker.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants
import com.ivoxavier.kaltracker.view.components.ListItemVerticalSpacer
import com.ivoxavier.kaltracker.view.components.QuickAdditionText
import com.ivoxavier.kaltracker.viewmodel.QuickAdditionViewModel

class ProductNameCaloriesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply{
            setContent{
                val viewModel = viewModel<QuickAdditionViewModel>(viewModelStoreOwner = requireActivity())
                LazyColumn{
                    item{
                        QuickAdditionText(viewModel,resources.getString(R.string.quick_addition_product_name),KalTrackerConstants.QUICK_ADDITION.PRODUCT_NAME)
                        QuickAdditionText(viewModel,resources.getString(R.string.quick_addition_product_calories),KalTrackerConstants.QUICK_ADDITION.PRODUCT_CALORIES)
                        ListItemVerticalSpacer()
                        NutriscoreList()
                    }
                }

            }
        }
    }
}


@Composable
fun NutriscoreList(){
    val isListExpanded = remember {
        mutableStateOf(false)
    }

    val itemPostion = remember {
        mutableStateOf(0)
    }

    val nutriscoreList = listOf(
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.A,
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.B,
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.C,
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.D,
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.E
    )


    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { isListExpanded.value = true }
            ) {
                Text(text = stringResource(id = R.string.quick_addition_nutriscore))
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                    contentDescription = "DropDown Icon"
                )
            }
            DropdownMenu(
                expanded = isListExpanded.value,
                onDismissRequest = { isListExpanded.value = false }
            ) {
                nutriscoreList.forEachIndexed { index, nutriscore ->
                    DropdownMenuItem(
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,) {
                                // Nutriscore Card
                                Box(
                                    modifier = Modifier
                                        .size(24.dp) // Adjust size as needed
                                        .background(getNutriscoreColor(nutriscore)) // Get color based on nutriscore value
                                ) {
                                    Text(
                                        text = nutriscore,
                                        color = Color.White, // Or any suitable contrasting color
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }
                                Spacer(modifier = Modifier.width(8.dp)) // Add some space between card and text
                                //Text(text = nutriscore)
                            }
                        },
                        onClick = {
                            isListExpanded.value = false
                            itemPostion.value = index
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun getNutriscoreColor(nutriscore: String): Color {
    return when (nutriscore) {
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.A -> Color(0xFF007E33) // Green
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.B -> Color(0xFF7CB342) // Light Green
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.C -> Color(0xFFFFF176) // Yellow
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.D -> Color(0xFFFFA726) // Orange
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.E -> Color(0xFFF44336) // Red
        else -> Color.LightGray // Default color if no match
    }
}