package com.ivoxavier.kaltracker.view.fragments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.view.components.UserProfileConfigAgePicker
import com.ivoxavier.kaltracker.view.components.UserProfileConfigCard
import com.ivoxavier.kaltracker.view.components.UserProfileConfigHeaderText
import com.ivoxavier.kaltracker.viewmodel.UserProfileConfigViewModel



class UserDetailsFragment(): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                    UserDetailsList()
                }
            }
        }
    }

fun setSexAtBirth(sex: Int){}

@Composable
fun UserDetailsList(){
    val viewModel = UserProfileConfigViewModel(Application())
    val context = LocalContext.current
    var selectedCardSexIndex by remember { mutableStateOf(-1) }

    fun changeCardSexSelection(index: Int){
        selectedCardSexIndex = if (selectedCardSexIndex == index) -1 else index  // Toggle selection
    }
    LazyColumn {
        items(1){
            UserProfileConfigHeaderText(headerText = context.getString(R.string.user_config_profile_header_sex_at_birth_text))
            UserProfileConfigCard(
                isSelected = selectedCardSexIndex == 0,
                type = viewModel.userProfileCardTypes[7],
                image = R.drawable.male_svgrepo_com ,
                label = context.getString(R.string.user_config_profile_card_male_sex_at_birth),
                onClick = {
                    changeCardSexSelection(0)
                    viewModel.setSexAtBirth(selectedSex = 0)
                }
            )
            UserProfileConfigCard(
                isSelected = selectedCardSexIndex == 1,
                type = viewModel.userProfileCardTypes[8],
                image = R.drawable.female_gender_svgrepo_com,
                label= context.getString(R.string.user_config_profile_card_female_sex_at_birth),
                onClick = {
                    changeCardSexSelection(1)
                    viewModel.setSexAtBirth(selectedSex = 1)
                }
            )
            UserProfileConfigHeaderText(headerText=context.getString(R.string.user_config_profile_header_age_text))
            UserProfileConfigAgePicker()
        }
    }
}