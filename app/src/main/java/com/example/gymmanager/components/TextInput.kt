package com.example.gymmanager.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/*
Created By Jackson Monteiro on 17/10/2023
*/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    label: String,
    modifier: Modifier?,
    keyboard: KeyboardOptions?,
    isPasswordField: Boolean
) {
    var value: String by remember { mutableStateOf("") }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = { value = it },
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
        visualTransformation = if (isPasswordField && passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        trailingIcon = {
            IconButton(onClick = {passwordVisibility = !passwordVisibility}) {
                Icon(imageVector = Icons.Filled.Visibility, contentDescription = "")
            }
        }
    )
}

@Preview
@Composable
fun TextInputPreview() {
    TextInput(
        label = "E-mail",
        modifier = null,
        keyboard = null,
        isPasswordField = true
    )
}
