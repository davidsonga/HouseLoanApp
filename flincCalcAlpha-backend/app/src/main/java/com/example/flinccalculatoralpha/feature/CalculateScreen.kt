package com.example.flinccalculatoralpha.feature

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flinccalculatoralpha.R
import com.example.flinccalculatoralpha.components.FilledButtonFl
import com.example.flinccalculatoralpha.components.OutlinedTextFieldFl
import com.example.flinccalculatoralpha.components.Title
import com.example.flinccalculatoralpha.navigation.Screens
import java.text.NumberFormat
import java.util.Locale
class SharedViewModel : ViewModel() {
    var price: Double = 0.0
    var loan: Double = 0.0
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculateScreen(navController: NavController, viewModel: SharedViewModel) {
    // Create mutable state variables to hold property price and loan amount
    var propertyPrice by remember { mutableStateOf("") }
    var loanAmount by remember { mutableStateOf("") }

    // Function to handle calculation
    val calculateCosts: () -> Unit = {
        // Convert property price and loan amount to Double

        val price = propertyPrice.replace(Regex("[^\\d.]"), "").toDoubleOrNull()
        val loan = loanAmount.replace(Regex("[^\\d.]"), "").toDoubleOrNull()



        // Check if both inputs are valid
        if (price != null && loan != null) {
            // Call calculate function from CostCalculator
         //   CostCalculator().calculate(price, loan, viewModel) { costDetails, exception ->
             //   if (costDetails != null) {
                    // If calculation succeeds, navigate to SummaryScreen
                //    navController.navigate(Screens.summaryScreen)
              //  } else {
                    // Handle error
                    // For simplicity, you can display a toast or a snackbar indicating the error
            Log.d("Navigation", "CalculateScreen: Price: $price, Loan: $loan")
            viewModel.price = price
            viewModel.loan = loan
            navController.navigate(Screens.summaryScreen)


            //}
           // }
        } else {
            // Handle invalid input
            // For simplicity, you can display a toast or a snackbar indicating the error
            Log.d("Navigation", "CalculateScreen: Price: $price, Loan: $loan")




        }
    }

    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Title(title = stringResource(id = R.string.transfer_and_bond_cost_calculator))
            Spacer(modifier = Modifier.size(24.dp))
            // Text field for property purchase price
            OutlinedTextFieldFl(
                value = propertyPrice,
                onValueChange = { price -> propertyPrice = formatNumber(price) },
                label = stringResource(id = R.string.property_purchase_price)
            )
            Spacer(modifier = Modifier.size(34.dp))
            // Text field for loan amount
            OutlinedTextFieldFl(
                value = loanAmount,
                onValueChange = { loan -> loanAmount = formatNumber(loan) },
                label = stringResource(id = R.string.loan_amount)
            )
            Spacer(modifier = Modifier.size(34.dp))
            // Button to trigger calculation
            FilledButtonFl(
                onClick = { calculateCosts() },
                label = stringResource(id = R.string.calculate),
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
    }
}

// Function to format number input with commas and prefix "R"
private fun formatNumber(value: String): String {
    // Remove non-numeric characters and parse the value as a double
    val numericValue = value.replace(Regex("[^\\d.]"), "").toDoubleOrNull() ?: 0.0
    val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault())
    // Format the numeric value with commas and prefix "R"
    return "R" + numberFormat.format(numericValue)
}
@Preview(showBackground = true)
@Composable
fun display() {
    // Create a mock NavController instance for previewing purposes
    val navController = rememberNavController()

    // Create a mock ViewModel instance for previewing purposes
    val viewModel = remember { CostDetailsViewModel() }

 //   CalculateScreen(navController, viewModel)
}
