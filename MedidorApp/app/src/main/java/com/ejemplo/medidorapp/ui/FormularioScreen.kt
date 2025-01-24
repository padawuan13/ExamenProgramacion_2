package com.ejemplo.medidorapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import com.ejemplo.medidorapp.R


@Composable
fun FormularioScreen(
    viewModel: LecturaViewModel,
    onRegistroExitoso: () -> Unit
) {
    var tipoSeleccionado by remember { mutableStateOf("Agua") }
    var valorMedido by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Registro Medidor")

        OutlinedTextField(
            value = valorMedido,
            onValueChange = { valorMedido = it },
            label = { Text("Valor") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha (dd-MM-yyyy)") },
            modifier = Modifier.fillMaxWidth(),
        )

        Text(text = "Medidor de:")
        Row {
            RadioButton(
                selected = (tipoSeleccionado == "Agua"),
                onClick = { tipoSeleccionado = "Agua" }
            )
            Text(text = "Agua")

            Spacer(modifier = Modifier.width(8.dp))

            RadioButton(
                selected = (tipoSeleccionado == "Luz"),
                onClick = { tipoSeleccionado = "Luz" }
            )
            Text(text = "Luz")

            Spacer(modifier = Modifier.width(8.dp))

            RadioButton(
                selected = (tipoSeleccionado == "Gas"),
                onClick = { tipoSeleccionado = "Gas" }
            )
            Text(text = "Gas")
        }

        Button(
            onClick = {
                val valor = valorMedido.toIntOrNull() ?: 0
                viewModel.agregarLectura(tipoSeleccionado, valor, fecha)
                onRegistroExitoso()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Registrar medición")


        }
    }
}



