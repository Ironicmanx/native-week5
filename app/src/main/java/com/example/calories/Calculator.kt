package com.example.calories


 fun calculateCalories(weight: String, intensity: String, isMale: Boolean): String {
    val calorieFactor = when (intensity) {
        "Low" -> if (isMale) 1.2 else 1.1
        "Moderate" -> if (isMale) 1.55 else 1.4
        "High" -> if (isMale) 1.9 else 1.7
        else -> 1.0
    }

    return if (weight.isNotEmpty()) {
        weight.toFloatOrNull()?.let {
            (it * calorieFactor).toString()
        } ?: "Invalid weight"
    } else {
        "Enter your weight"
    }
}
