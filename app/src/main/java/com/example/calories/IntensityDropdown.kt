package com.example.calories

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown

@Composable
fun IntensityDropdown(intensity: String, onIntensityChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val intensities = listOf("Low", "Moderate", "High")

    OutlinedTextField(
        value = intensity,
        onValueChange = {},
        label = { Text("Activity Level") },
        readOnly = true,
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        trailingIcon = {
            IconButton(onClick = { expanded = true }) {
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
            }
        }
    )

    if (expanded) {
        AlertDialog(
            onDismissRequest = { expanded = false },
            title = { Text("Select Activity Level") },
            text = {
                Column {
                    intensities.forEach { item ->
                        TextButton(onClick = {
                            onIntensityChange(item)
                            expanded = false
                        }) {
                            Text(item)
                        }
                    }
                }
            },
            confirmButton = {
                Button(onClick = { expanded = false }) {
                    Text("Done")
                }
            },
            dismissButton = {
                Button(onClick = { expanded = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}
