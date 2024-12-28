package com.ivoxavier.kaltracker.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants
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
        modifier = Modifier.fillMaxWidth()
    ) {
       Box {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    isListExpanded.value = true
                }
            ) {
                Text(text = nutriscoreList[itemPostion.value])
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                    contentDescription = "DropDown Icon"
                )
            }
           DropdownMenu(expanded = isListExpanded.value,
               onDismissRequest = {
               isListExpanded.value = false
           }){
               nutriscoreList.forEachIndexed { index, nutriscore ->
                   DropdownMenuItem(text = {
                       Text(text = nutriscore)
                   }, onClick = {
                       isListExpanded.value = false
                       itemPostion.value = index
                   })
               }
           }
       }
    }
}