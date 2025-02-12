package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.databinding.ActivityQuickAdditionBinding
import com.ivoxavier.kaltracker.view.fragments.ProductMacrosFragment
import com.ivoxavier.kaltracker.view.fragments.ProductNameCaloriesFragment
import com.ivoxavier.kaltracker.viewmodel.QuickAdditionViewModel

class QuickAdditionActivity: AppCompatActivity() {

    private lateinit var binding: ActivityQuickAdditionBinding


    //make viewModel acessible by ViewPagerAdapter -> Fragments
    //its not the best implementation,
    //each fragment *should* have its own ViewModel
    companion object {
        lateinit var viewModel: QuickAdditionViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // since we're using AppCompat here had to set a theme on values folder themes.xml
        // this app template was initially only jetpack compose
        setTheme(com.google.android.material.R.style.Theme_AppCompat)

        //hide actionbar
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this)[QuickAdditionViewModel::class.java]

        super.onCreate(savedInstanceState)

        val mealCategory = intent.getIntExtra("mealCategory", -1)
        viewModel.mealCategory = mealCategory


        binding = ActivityQuickAdditionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = resources.getString(R.string.quick_addition_product_name_calories)
                1 -> tab.text = resources.getString(R.string.quick_addition_product_macros)
            }
        }.attach()
    }

    class ViewPagerAdapter(private val activity: AppCompatActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ProductNameCaloriesFragment()
                1 -> ProductMacrosFragment()
                else -> throw IllegalArgumentException("Invalid position")
            }
        }
    }
}