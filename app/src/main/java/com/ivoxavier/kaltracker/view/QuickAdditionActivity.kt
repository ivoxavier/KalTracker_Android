package com.ivoxavier.kaltracker.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.databinding.ActivityQuickAdditionBinding

class QuickAdditionActivity: AppCompatActivity() {

    private lateinit var binding: ActivityQuickAdditionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        // since we're using AppCompat here had to set a theme on values folder themes.xml
        // this app template was initially only jetpack compose
        setTheme(com.google.android.material.R.style.Theme_AppCompat)
        super.onCreate(savedInstanceState)
        binding = ActivityQuickAdditionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}