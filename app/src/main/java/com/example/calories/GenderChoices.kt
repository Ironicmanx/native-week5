package com.example.calories

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text

@Composable
fun GenderChoices(isMale: Boolean, onGenderChange: (Boolean) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        RadioButton(
            selected = isMale,
            onClick = { onGenderChange(true) }
        )
        Text("Male", modifier = Modifier.padding(end = 16.dp))
        RadioButton(
            selected = !isMale,
            onClick = { onGenderChange(false) }
        )
        Text("Female")
    }
}
