package com.ivoxavier.kaltracker.view.fragments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.view.UserProfileConfigActivity
import com.ivoxavier.kaltracker.view.components.UserProfileConfigCard
import com.ivoxavier.kaltracker.view.components.UserProfileConfigHeaderText
import com.ivoxavier.kaltracker.view.components.UserProfileConfigPeriodDialog
import com.ivoxavier.kaltracker.viewmodel.UserProfileConfigViewModel

class ObjectiveFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val viewModel = viewModel<UserProfileConfigViewModel>(viewModelStoreOwner = requireActivity())
                ObjectiveList(viewModel)
            }
        }
    }
}

//get the list of objectives
@Composable
fun ObjectiveList(viewModel: UserProfileConfigViewModel){
    val context = LocalContext.current
    var selectedCardPlanIndex by remember { mutableStateOf(-1) }
    var selectedCardActivityIndex by remember { mutableStateOf(-1) }

    var showDialog by remember { mutableStateOf(false) }

    val showPeriodDialog = viewModel.periodDialog.observeAsState()
    LaunchedEffect(showPeriodDialog.value) {
        showDialog = showPeriodDialog.value ?: false
    }

    if(showDialog){
        if(selectedCardPlanIndex == 2){
            UserProfileConfigPeriodDialog(context.getString(R.string.user_config_profile_dialog_gain_weight_text), viewModel)
            showDialog = true
        } else if(selectedCardPlanIndex == 0){
            UserProfileConfigPeriodDialog(context.getString(R.string.user_config_profile_dialog_loose_weight_text), viewModel)
            showDialog = true
        }
    }


    fun changeCardPlanSelection(index: Int) {
        selectedCardPlanIndex = if (selectedCardPlanIndex == index) -1 else index  // Toggle selection
    }

    fun changeCardActivitySelection(index: Int) {
        selectedCardActivityIndex = if (selectedCardActivityIndex == index) -1 else index  // Toggle selection
    }

    LazyColumn {
        items(1){
            UserProfileConfigHeaderText(headerText = context.getString(R.string.user_config_profile_header_plan_text))
            //UserProfileConfigCard plan
            UserProfileConfigCard(
                isSelected = selectedCardPlanIndex == 0,
                type = viewModel.userProfileCardTypes[0],
                image = R.drawable.shoe_svgrepo_com,
                label = context.getString(R.string.user_config_profile_card_loose_weight),
                onClick = {
                    changeCardPlanSelection(0)
                    viewModel.setPlan(selectedPlan = 1)
                    viewModel.showDialog()
                }
            )
            //UserProfileConfigCard plan
            UserProfileConfigCard(
                isSelected = selectedCardPlanIndex == 1,
                type = viewModel.userProfileCardTypes[1],
                image = R.drawable.kilograms_justice_svgrepo_com,
                label = context.getString(R.string.user_config_profile_card_maintain_weight),
                onClick = {
                    changeCardPlanSelection(1)
                    viewModel.setPlan(selectedPlan = 0)
                    viewModel.setPeriodPlan(0)
                }
            )
            //UserProfileConfigCard plan
            UserProfileConfigCard(
                isSelected = selectedCardPlanIndex == 2,
                type = viewModel.userProfileCardTypes[2],
                image = R.drawable.dumbbell_gym_svgrepo_com,
                label = context.getString(R.string.user_config_profile_card_gain_weight),
                onClick = {
                    changeCardPlanSelection(2)
                    viewModel.setPlan(selectedPlan = 2)
                    viewModel.showDialog()
                }
            )
            UserProfileConfigHeaderText(headerText = context.getString(R.string.user_config_profile_header_activity_text))
            //UserProfileConfigCard activity
            UserProfileConfigCard(
                isSelected = selectedCardActivityIndex == 3,
                type = viewModel.userProfileCardTypes[3],
                image = R.drawable.cooking_stew_svgrepo_com,
                label= context.getString(R.string.user_config_profile_card_very_light_activity),
                onClick = {
                    changeCardActivitySelection (3)
                    viewModel.setActivity(selectedActivity = 0)
                }
            )
            //UserProfileConfigCard activity
            UserProfileConfigCard(
                isSelected = selectedCardActivityIndex == 4,
                type = viewModel.userProfileCardTypes[4],
                image = R.drawable.walking_the_dog_svgrepo_com,
                label= context.getString(R.string.user_config_profile_card_light_activity),
                onClick = {
                    changeCardActivitySelection(4)
                    viewModel.setActivity(selectedActivity = 1)
                }
            )
            //UserProfileConfigCard activity
            UserProfileConfigCard(
                isSelected = selectedCardActivityIndex == 5,
                type = viewModel.userProfileCardTypes[5],
                image = R.drawable.cycling_color_svgrepo_com,
                label= context.getString(R.string.user_config_profile_card_moderate_activity),
                onClick = {
                    changeCardActivitySelection(5)
                    viewModel.setActivity(selectedActivity = 2)
                }
            )
            //UserProfileConfigCard activity
            UserProfileConfigCard(
                isSelected = selectedCardActivityIndex == 6,
                type = viewModel.userProfileCardTypes[6],
                image = R.drawable.soccer_svgrepo_com,
                label= context.getString(R.string.user_config_profile_card_heavy_activity),
                onClick = {
                    changeCardActivitySelection(6)
                    viewModel.setActivity(selectedActivity = 3)
                }
            )
        }
    }
}
