package com.example.calories

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text

@Composable
fun WeightField(weight: String, onWeightChange: (String) -> Unit) {
    OutlinedTextField(
        value = weight,
        onValueChange = onWeightChange,
        label = { Text("Enter your weight (kg)") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}
