package com.example.flinccalculatoralpha.util

import androidx.annotation.DrawableRes
import com.example.flinccalculatoralpha.R

sealed class OnBoardingPage(
    @DrawableRes
    val image:Int,
    val description: Int
){
    object First:OnBoardingPage(
        image = R.drawable.flinc,
        description = R.string.onboardingtext1
    )
    object Second:OnBoardingPage(
        image = R.drawable.flinc,
        description = R.string.onboardingtext2
    )
    object Third:OnBoardingPage(
        image = R.drawable.flinc,
        description = R.string.onboardingtext3
    )
}