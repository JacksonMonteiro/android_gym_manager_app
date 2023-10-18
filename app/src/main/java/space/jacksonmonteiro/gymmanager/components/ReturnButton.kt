package space.jacksonmonteiro.gymmanager.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/*
Created By Jackson Monteiro on 17/10/2023
*/


@Composable
fun ReturnButton(action: () -> Unit) {
    IconButton(
        onClick = action,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.height(48.dp).width(48.dp).border(
            width = 1.dp,
            color = Color.Black,
            shape = RoundedCornerShape(8.dp)
        ).clip(
            shape = RoundedCornerShape(8.dp)
        ),
    ) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Botão de Voltar")
    }
}

@Preview(showBackground = true)
@Composable
fun ReturnButtonPreview() {
    ReturnButton(
        action = {}
    )

}