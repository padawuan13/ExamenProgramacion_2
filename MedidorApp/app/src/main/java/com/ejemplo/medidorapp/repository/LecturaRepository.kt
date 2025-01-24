package com.ejemplo.medidorapp.repository

import com.ejemplo.medidorapp.data.Lectura
import com.ejemplo.medidorapp.data.LecturaDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LecturaRepository(private val lecturaDao: LecturaDao) {

    suspend fun getLecturas(): List<Lectura> {
        return withContext(Dispatchers.IO) {
            lecturaDao.getAllLecturas()
        }
    }

    suspend fun insertLectura(lectura: Lectura) {
        withContext(Dispatchers.IO) {
            lecturaDao.insertLectura(lectura)
        }
    }

}
