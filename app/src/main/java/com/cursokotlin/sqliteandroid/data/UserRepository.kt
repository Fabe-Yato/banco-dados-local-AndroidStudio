package com.cursokotlin.sqliteandroid.data

class UserRepository (private val userDao: UserDao){

    val selectUsers = userDao.selectUsers()

    fun addUSer(usuario: Usuario){
        userDao.addUser(usuario)
    }


} //se conecta com o banco e faz as requisições necessárias