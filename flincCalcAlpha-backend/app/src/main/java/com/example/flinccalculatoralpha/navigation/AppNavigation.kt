package com.example.flinccalculatoralpha.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.flinccalculatoralpha.feature.CalculateScreen
import com.example.flinccalculatoralpha.feature.CostCalculator
import com.example.flinccalculatoralpha.feature.CostDetails
import com.example.flinccalculatoralpha.feature.CostDetailsViewModel
import com.example.flinccalculatoralpha.feature.HomeScreen
import com.example.flinccalculatoralpha.feature.SharedViewModel

import com.example.flinccalculatoralpha.feature.SummaryScreen
import com.example.flinccalculatoralpha.onboarding.OnboardingScreen
import kotlinx.coroutines.launch


@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation(navController: NavHostController, viewModel: SharedViewModel) {
  //  val costDetails by viewModel.costDetails.observeAsState()

    val coroutineScope = rememberCoroutineScope()

    NavHost(navController = navController, startDestination = Screens.onboardingScreen) {
        composable(route = Screens.onboardingScreen) {
            OnboardingScreen(navController = navController)
        }
        composable(route = Screens.homeScreen) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.calculateScreen) {
            CalculateScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.summaryScreen) {
            val backStackEntry by navController.currentBackStackEntryAsState()
            val priceString = backStackEntry?.arguments?.getString("price")
            val loanString = backStackEntry?.arguments?.getString("loan")

            // Check for null arguments and log if necessary
                Log.d("Navigation", "SummaryScreen: Price: ${viewModel.price}, Loan: ${viewModel.loan}")
                var costDetailsValue by remember { mutableStateOf<List<CostDetails>?>(null) }
                LaunchedEffect(key1 = costDetailsValue) {
                    coroutineScope.launch {
                        val retrievedDetails = CostCalculator().retrieve(viewModel.price, viewModel.loan)
                        costDetailsValue = retrievedDetails
                    }
                }

                costDetailsValue?.let {
                    it.forEach { element ->
                        SummaryScreen(navController = navController, costDetails = element)
                    }

            }
        }
    }
}
