package com.ivoxavier.kaltracker.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants
import com.ivoxavier.kaltracker.view.components.QuickAdditionText
import com.ivoxavier.kaltracker.viewmodel.QuickAdditionViewModel

class ProductMacrosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply{
            setContent{
                val viewModel = viewModel<QuickAdditionViewModel>(viewModelStoreOwner = requireActivity())

                Scaffold { paddingValues ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(paddingValues)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        item{
                            Text(
                                text = stringResource(id = R.string.quick_addition_product_macros),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            QuickAdditionText(viewModel,resources.getString(R.string.quick_addition_macro_fat), KalTrackerConstants.QUICK_ADDITION.PRODUCT_MACROS)
                            QuickAdditionText(viewModel,resources.getString(R.string.quick_addition_macro_protein), KalTrackerConstants.QUICK_ADDITION.PRODUCT_MACROS)
                            QuickAdditionText(viewModel,resources.getString(R.string.quick_addition_macro_carbo), KalTrackerConstants.QUICK_ADDITION.PRODUCT_MACROS)
                        }
                    }
                }
            }
        }
    }
}