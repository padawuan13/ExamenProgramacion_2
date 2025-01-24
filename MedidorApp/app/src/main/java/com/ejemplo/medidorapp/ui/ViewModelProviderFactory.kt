package com.ejemplo.medidorapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ejemplo.medidorapp.repository.LecturaRepository

class LecturaViewModelFactory(
    private val repository: LecturaRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LecturaViewModel::class.java)) {
            return LecturaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
