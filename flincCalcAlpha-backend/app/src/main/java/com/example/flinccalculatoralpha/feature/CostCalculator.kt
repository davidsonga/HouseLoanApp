package com.example.flinccalculatoralpha.feature

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONObject

class CostCalculator {
    suspend fun retrieve(price: Double, loan: Double): List<CostDetails> = withContext(Dispatchers.IO) {
        val webServiceURL =
            "https://calcs.multinet.co.za/Code/AssociatedCost.ashx?PurchPrice=$price&LoanAmt=$loan"

        val urlConnection = (URL(webServiceURL).openConnection() as HttpURLConnection).apply {
            requestMethod = "POST"
        }

        val responseCode = urlConnection.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) {
            val response = urlConnection.inputStream.bufferedReader().use { it.readText() }
            val obj = JSONObject(response)

            val transferDuty = obj.optDouble("tDuty", 0.0)
            val transferDeed = obj.optDouble("tDO", 0.0)
            val transferAttorneyFees = obj.optDouble("tCost", 0.0)
            val transferPetties = obj.optDouble("tPetties", 0.0)
            val bondDeed = obj.optDouble("bDO", 0.0)
            val bondAttorneyFees = obj.optDouble("bCosts", 0.0)
            val bondPetties = obj.optDouble("bPetties", 0.0)

            val totalTransferCosts =
                transferDuty + transferDeed + transferAttorneyFees + transferPetties
            val totalBondCosts = bondDeed + bondAttorneyFees + bondPetties
            val totalCosts = totalTransferCosts + totalBondCosts

            return@withContext listOf(
                CostDetails(
                    transferDuty,
                    transferDeed,
                    transferAttorneyFees,
                    transferPetties,
                    bondDeed,
                    bondAttorneyFees,
                    bondPetties,
                    totalTransferCosts,
                    totalBondCosts,
                    totalCosts
                )
            )
        }
        return@withContext emptyList()
    }

}

