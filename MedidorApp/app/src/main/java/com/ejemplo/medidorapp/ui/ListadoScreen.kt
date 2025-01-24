package com.ejemplo.medidorapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ejemplo.medidorapp.data.Lectura
import com.ejemplo.medidorapp.R


@Composable
fun ListadoScreen(
    viewModel: LecturaViewModel,
    onFabClick: () -> Unit
) {
    val listaLecturas by viewModel.lecturas.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onFabClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar Lectura"
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(listaLecturas) { lectura ->
                LecturaItem(lectura)
            }
        }
    }
}

@Composable
fun LecturaItem(lectura: Lectura) {
    val iconId = when (lectura.tipoGasto.uppercase()) {
        "AGUA" -> R.drawable.ic_agua
        "LUZ" -> R.drawable.ic_luz
        "GAS" -> R.drawable.ic_gas
        else -> R.drawable.ic_launcher_foreground
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.weight(1f),
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = lectura.tipoGasto,
                modifier = Modifier
                    .size(28.dp)
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = lectura.tipoGasto,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Text(
            text = lectura.valorMedido.toString(),
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = lectura.fecha,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
    }
}


