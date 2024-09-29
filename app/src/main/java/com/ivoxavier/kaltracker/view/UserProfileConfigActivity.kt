package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ivoxavier.kaltracker.ui.theme.KalTrackerTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.CardElevation
import androidx.fragment.app.Fragment
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

class UserProfileConfigActivity : AppCompatActivity() {

    private lateinit var viewModel: UserProfileConfigViewModel
    private lateinit var binding: ActivityUserProfileConfigBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // since we're using AppCompat here had to set a theme on values folder themes.xml
        // this app template was initially only jetpack compose
        setTheme(com.google.android.material.R.style.Theme_AppCompat)

        super.onCreate(savedInstanceState)
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
}

class ViewPagerAdapter(private val activity: AppCompatActivity) : FragmentStateAdapter(activity) {
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