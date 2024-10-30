package com.ivoxavier.kaltracker.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.ivoxavier.kaltracker.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        if (viewModel.isCleanInstall()) {
            startActivity(Intent(applicationContext, UserProfileConfigActivity::class.java))
            finish()
        }else{
            startActivity(Intent(applicationContext, HomeActivity::class.java))
            finish()
        }
    }
}

