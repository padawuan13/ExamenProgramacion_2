package com.ejemplo.medidorapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LecturaDao {
    @Query("SELECT * FROM lecturas ORDER BY id DESC")
    suspend fun getAllLecturas(): List<Lectura>

    @Insert
    suspend fun insertLectura(lectura: Lectura)

}
