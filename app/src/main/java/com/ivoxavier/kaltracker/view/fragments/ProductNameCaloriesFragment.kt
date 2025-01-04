package com.ivoxavier.kaltracker.view.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants
import com.ivoxavier.kaltracker.service.repository.model.IngestionModel
import com.ivoxavier.kaltracker.service.repository.model.UserFoodsListModel
import com.ivoxavier.kaltracker.service.repository.utils.FormatDate
import com.ivoxavier.kaltracker.view.components.QuickAdditionText
import com.ivoxavier.kaltracker.viewmodel.QuickAdditionViewModel
import com.ivoxavier.kaltracker.viewmodel.QuickListFoodsViewModel

class ProductNameCaloriesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply{
            setContent{
                val viewModel = viewModel<QuickAdditionViewModel>(viewModelStoreOwner = requireActivity())
                val viewModel2 = viewModel<QuickListFoodsViewModel>(viewModelStoreOwner = requireActivity())
                val context = LocalContext.current
                var showFAB by remember { mutableStateOf(false) }

                val focusManager = LocalFocusManager.current

                Scaffold(
                    floatingActionButton = {
                        if(showFAB){
                            FloatingActionButton(onClick = {
                                if(viewModel.productName.value != null && viewModel.calories.value != null &&
                                    viewModel.fat_100g.value != null && viewModel.fat_100g.value.toString().isNotEmpty() &&
                                    viewModel.carbo_100g.value != null && viewModel.carbo_100g.value.toString().isNotEmpty() &&
                                    viewModel.protein_100g.value != null && viewModel.protein_100g.value.toString().isNotEmpty()
                                    ){

                                    //check if the productName already exists in the userfoodslist table
                                    isNewProduct(viewModel,viewModel2)

                                    //register the product in the ingestions table
                                    registerIngestionProduct(viewModel)

                                    focusManager.clearFocus()
                                    val activity = context as Activity
                                    activity.finish()
                                }
                                else{
                                    Toast.makeText(requireContext(), resources.getString(R.string.global_string_enter_value), Toast.LENGTH_SHORT).show()
                                }

                            }) {
                                Icon(Icons.Filled.Add, contentDescription = "Add")
                            }
                        }

                    },
                    floatingActionButtonPosition = FabPosition.End
                ) { paddingValues ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(paddingValues)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            Text(
                                text = stringResource(id = R.string.quick_addition_product_name_calories),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            QuickAdditionText(viewModel,resources.getString(R.string.quick_addition_product_name),KalTrackerConstants.QUICK_ADDITION.PRODUCT_NAME, onProductNameChange = { showFAB = it.isNotEmpty() })

                            QuickAdditionText(viewModel,resources.getString(R.string.quick_addition_product_calories),KalTrackerConstants.QUICK_ADDITION.PRODUCT_CALORIES)

                            Spacer(modifier = Modifier.height(16.dp))

                            NutriscoreList(viewModel)

                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}




fun isNewProduct(viewModel: QuickAdditionViewModel, viewModel2: QuickListFoodsViewModel){
    if(viewModel2.isNewProduct(viewModel.productName.value!!)){
        viewModel.getUserId()?.let{ userId ->
            val model = UserFoodsListModel().apply {
                this.name = viewModel.productName.value!!
                this.cal = viewModel.calories.value!!.toInt()
                this.nutriscore = viewModel.nutriscore.value!!
                this.fat = viewModel.fat_100g.value!!.toDouble()
                this.carbo = viewModel.carbo_100g.value!!.toDouble()
                this.protein = viewModel.protein_100g.value!!.toDouble()
                this.id_user = userId
            }
            viewModel2.save(model)
        }
    }
}


fun registerIngestionProduct(viewModel: QuickAdditionViewModel){
    viewModel.getUserId()?.let{ userId ->
        val model = IngestionModel().apply {
            this.name = viewModel.productName.value!!
            this.cal = viewModel.calories.value!!.toInt()
            this.nutriscore = viewModel.nutriscore.value!!
            this.fat = viewModel.fat_100g.value!!.toDouble()
            this.carbo = viewModel.carbo_100g.value!!.toDouble()
            this.protein = viewModel.protein_100g.value!!.toDouble()
            this.meal = viewModel.mealCategory
            this.id_user = userId
            this.date = FormatDate(System.currentTimeMillis())
        }
        //save to db
        viewModel.save(model)
    }
}

@Composable
fun NutriscoreList(viewModel: QuickAdditionViewModel){
    var selectedNutriscore by remember { mutableStateOf("") } // Add this line
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
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { isListExpanded.value = true }
                    .padding(8.dp)
            ) {
                Text(text = stringResource(id = R.string.quick_addition_nutriscore) + ":")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = if (selectedNutriscore.isEmpty()) stringResource(id = R.string.global_string_nothing_selected) else selectedNutriscore)
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
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .background(getNutriscoreColor(nutriscore))
                                ) {
                                    Text(
                                        text = nutriscore,
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                //Text(text = nutriscore)
                            }
                        },
                        onClick = {
                            isListExpanded.value = false
                            selectedNutriscore = nutriscore
                            itemPostion.value = index
                            viewModel.setNutriscore(nutriscore)
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
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.A -> KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.COLOR.A
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.B -> KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.COLOR.B
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.C -> KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.COLOR.C
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.D -> KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.COLOR.D
        KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.E -> KalTrackerConstants.QUICK_ADDITION.NUTRISCORE.COLOR.E
        else -> Color.LightGray
    }
}