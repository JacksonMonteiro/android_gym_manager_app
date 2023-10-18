package space.jacksonmonteiro.gymmanager.components
/*
Created By Jackson Monteiro on 17/10/2023
*/

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    label: String,
    modifier: Modifier?,
    keyboard: KeyboardOptions?,
    onValueChange: (String) -> Unit
) {
    var value: String by remember { mutableStateOf("") }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = {
            value = it
            onValueChange(it)
        },
        label = { Text(text = label) },
        modifier = modifier
            ?: Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(24.dp)
                )
                .clip(RoundedCornerShape(24.dp)),
        singleLine = true,
        keyboardOptions = keyboard ?: KeyboardOptions.Default,
        visualTransformation = VisualTransformation.None,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    label: String,
    modifier: Modifier?,
    keyboard: KeyboardOptions?,
    onValueChange: (String) -> Unit
) {
    var value: String by remember { mutableStateOf("") }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = {
            value = it
            onValueChange(it)
        },
        label = { Text(text = label) },
        modifier = modifier
            ?: Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(24.dp)
                )
                .clip(RoundedCornerShape(24.dp)),
        singleLine = true,
        keyboardOptions = keyboard ?: KeyboardOptions.Default,
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                val image =
                    if (passwordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                val description = if (passwordVisibility) "Esconder Senha" else "Mostrar senha"
                Icon(imageVector = image, contentDescription = description)
            }
        },
    )
}


@Preview
@Composable
fun TextInputPreview() {

}
