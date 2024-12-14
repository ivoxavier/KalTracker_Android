package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.databinding.ActivityUserProfileConfigBinding
import com.ivoxavier.kaltracker.view.fragments.BodyMeasureFragment
import com.ivoxavier.kaltracker.view.fragments.ObjectiveFragment
import com.ivoxavier.kaltracker.view.fragments.UserDetailsFragment
import com.ivoxavier.kaltracker.viewmodel.MainViewModel
import com.ivoxavier.kaltracker.viewmodel.UserProfileConfigViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModel
import com.ivoxavier.kaltracker.service.repository.Settings


class UserProfileConfigActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileConfigBinding
    //private lateinit var viewModel: UserProfileConfigViewModel

    //make viewModel acessible by ViewPagerAdapter -> Fragments
    //its not the best implementation,
    //each fragment *should* have its own ViewModel
    companion object {
        lateinit var viewModel: UserProfileConfigViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // since we're using AppCompat here had to set a theme on values folder themes.xml
        // this app template was initially only jetpack compose
        setTheme(com.google.android.material.R.style.Theme_AppCompat)

        viewModel = ViewModelProvider(this)[UserProfileConfigViewModel::class.java]

        super.onCreate(savedInstanceState)

        //catch value from intent(MenuActivity) and set it to viewModel, default value is false to avoid null pointer exception
        //when a profile is being created from scracth
        val isUpdate = intent.getBooleanExtra("isUpdate", false)
        viewModel.isUpdate = isUpdate

        binding = ActivityUserProfileConfigBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = resources.getString(R.string.user_config_profile_objetive_tab)
                1 -> tab.text = resources.getString(R.string.user_config_profile_user_details_tab)
                2 -> tab.text = resources.getString(R.string.user_config_profile_body_measure_tab)
            }
        }.attach()

    }

    override fun onResume() {
        super.onResume()
        val appSettings = Settings(this)
        val isUserConfigured = appSettings.isUserConfigured()

        //Verify if the user has its profile set on clean install, then finish this activity for no user interaction
        if(isUserConfigured){
            finish()
        }
    }

    class ViewPagerAdapter(private val activity: AppCompatActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ObjectiveFragment()
                1 -> UserDetailsFragment()
                2 -> BodyMeasureFragment()
                else -> throw IllegalArgumentException("Invalid position")
            }
        }
    }
}

