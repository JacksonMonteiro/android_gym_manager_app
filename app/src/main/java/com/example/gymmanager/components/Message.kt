package com.example.gymmanager.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


/*
Created By Jackson Monteiro on 17/10/2023
*/


@Composable
fun Message(message: String, fontSize: TextUnit?, color: Color?, fontWeight: FontWeight?, textAlign: TextAlign?, modifier: Modifier?) {
    Text(
        message,
        fontSize = fontSize ?: 16.sp,
        color = color ?: Color.Black,
        fontWeight = fontWeight ?: FontWeight.Normal,
        textAlign = textAlign ?: TextAlign.Center,
        modifier = modifier ?: Modifier.fillMaxWidth()
    );
}