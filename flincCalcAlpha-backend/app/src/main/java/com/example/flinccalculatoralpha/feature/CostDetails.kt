package com.example.flinccalculatoralpha.feature

data class CostDetails(
    val transferDuty: Double,
    val transferDeed: Double,
    val transferAttorneyFees: Double,
    val transferPetties: Double,
    val bondDeed: Double,
    val bondAttorneyFees: Double,
    val bondPetties: Double,
    val totalTransferCosts: Double,
    val totalBondCosts: Double,
    val totalCosts: Double
)