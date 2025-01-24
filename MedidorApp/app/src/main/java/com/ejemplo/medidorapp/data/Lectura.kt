package com.ejemplo.medidorapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lecturas")
data class Lectura(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val tipoGasto: String,   // "Agua", "Luz", "Gas"
    val valorMedido: Int,
    val fecha: String
)
