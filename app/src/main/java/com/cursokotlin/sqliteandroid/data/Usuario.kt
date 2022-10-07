package com.cursokotlin.sqliteandroid.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Criando a Entidade do banco de dados
@Entity(tableName = "user_table")
class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var nome: String,
    var sobrenome: String,
    var idade: Int
    ){


}