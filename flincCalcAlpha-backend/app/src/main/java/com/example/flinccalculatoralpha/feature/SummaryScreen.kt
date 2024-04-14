package com.example.flinccalculatoralpha.feature
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.flinccalculatoralpha.R
import com.example.flinccalculatoralpha.components.FilledButtonFl
import com.example.flinccalculatoralpha.components.TopAppBarFl
import com.example.flinccalculatoralpha.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SummaryScreen(navController: NavController, costDetails: CostDetails?) {

    Scaffold(
        topBar = { TopAppBarFl(title = stringResource(id = R.string.transfer_and_bond_cost_calculator), navController = navController ) },
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Column(modifier = Modifier.padding(paddingValues = it)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Total Cost: R${costDetails?.totalCosts}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Total Transfer Cost: R${costDetails?.totalTransferCosts}",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Transfer Duty: R${costDetails?.transferDuty}",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Transfer Deed: R${costDetails?.transferDeed}",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Transfer Attorney Fees: R${costDetails?.transferAttorneyFees}",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Transfer Petties: R${costDetails?.transferPetties}",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Total Bond Costs: R${costDetails?.totalBondCosts}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Bond Deed: R${costDetails?.bondDeed}",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Bond Attorney Fees: R${costDetails?.bondAttorneyFees}",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Bond Petties: R${costDetails?.bondPetties}",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
                Row(modifier = Modifier.fillMaxWidth(1f)) {
                    FilledButtonFl(
                        onClick = {
                            // Export functionality
                        },
                        label = stringResource(id = R.string.export),
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    FilledButtonFl(
                        onClick = {
                            navController.navigate(Screens.calculateScreen)
                        },
                        label = stringResource(id = R.string.new_summary)
                    )
                }
            }
        }
    }
}