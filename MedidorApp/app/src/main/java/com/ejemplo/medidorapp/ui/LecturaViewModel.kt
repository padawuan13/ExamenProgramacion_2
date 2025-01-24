package com.ejemplo.medidorapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ejemplo.medidorapp.data.Lectura
import com.ejemplo.medidorapp.repository.LecturaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LecturaViewModel(private val repository: LecturaRepository) : ViewModel() {

    private val _lecturas = MutableStateFlow<List<Lectura>>(emptyList())
    val lecturas: StateFlow<List<Lectura>> = _lecturas

    init {
        // Cargamos las lecturas
        loadLecturas()
    }

    private fun loadLecturas() {
        viewModelScope.launch {
            val data = repository.getLecturas()
            _lecturas.value = data
        }
    }

    fun agregarLectura(tipo: String, valor: Int, fecha: String) {
        viewModelScope.launch {
            val nuevaLectura = Lectura(
                tipoGasto = tipo,
                valorMedido = valor,
                fecha = fecha
            )
            repository.insertLectura(nuevaLectura)
            loadLecturas()
        }
    }

}
