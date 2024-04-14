package com.example.flinccalculatoralpha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.flinccalculatoralpha.feature.CostDetailsViewModel
import com.example.flinccalculatoralpha.feature.SharedViewModel
import com.example.flinccalculatoralpha.ui.theme.FlincCalculatorAlphaTheme
import com.example.flinccalculatoralpha.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlincCalculatorAlphaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val costDetailsViewModel = viewModel<CostDetailsViewModel>()
                    AppNavigation(navController = navController, viewModel = SharedViewModel())

                }
            }
        }
    }
}


