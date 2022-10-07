package com.cursokotlin.sqliteandroid.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    //Permite que o banco ignore os usuarios repetidos
    //também que insira dados ao banco
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(usuario: Usuario)

    //Lista todos os usuários da tabela user_table
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun selectUsers(): LiveData<List<Usuario>>
}