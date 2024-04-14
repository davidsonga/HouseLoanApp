package com.example.flinccalculatoralpha.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

@Composable
fun FilledButtonFl(
    onClick:() -> Unit,
    label:String,
    modifier: Modifier =Modifier
){
    Column {
        Button(onClick = { onClick.invoke() }, modifier = modifier) {
            Text(text = label, fontSize = 18.sp, fontStyle = FontStyle.Normal, fontFamily = FontFamily.SansSerif)
        }
    }

}