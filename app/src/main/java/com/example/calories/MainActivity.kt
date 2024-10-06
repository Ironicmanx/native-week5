
package com.example.calories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calories.ui.theme.CaloriesTheme
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaloriesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalorieScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CalorieScreen(modifier: Modifier = Modifier) {
    var weight by remember { mutableStateOf("") }
    var isMale by remember { mutableStateOf(true) }
    var intensity by remember { mutableStateOf("Moderate") }
    var result by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Heading(title = "Calories")
        Spacer(modifier = Modifier.height(8.dp))
        WeightField(weight = weight, onWeightChange = { weight = it })
        Spacer(modifier = Modifier.height(8.dp))
        GenderChoices(isMale = isMale, onGenderChange = { isMale = it })
        Spacer(modifier = Modifier.height(8.dp))
        IntensityDropdown(intensity = intensity, onIntensityChange = { intensity = it })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            result = calculateCalories(weight, intensity, isMale)
        }) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Calories Burned: $result") // Display result
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalorieScreen() {
    CaloriesTheme {
        CalorieScreen()
    }
}

