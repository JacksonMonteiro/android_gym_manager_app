package space.jacksonmonteiro.gymmanager.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/*
Created By Jackson Monteiro on 17/10/2023
*/


@Composable
fun Button(text: String, containerColor: Color, contentColor: Color, action: () -> Unit) {
    ElevatedButton(
        onClick = action,
        modifier = Modifier.fillMaxWidth().height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    )
    {
        Text(text, fontSize = 20.sp)
    }
}

@Preview
@Composable
fun PreviewButton() {
    Button(text = "Login", containerColor = MaterialTheme.colorScheme.primary, contentColor = Color.White, {})
}