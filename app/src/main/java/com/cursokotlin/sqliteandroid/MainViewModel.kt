package com.cursokotlin.sqliteandroid

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursokotlin.sqliteandroid.data.UserDatabase
import com.cursokotlin.sqliteandroid.data.UserRepository
import com.cursokotlin.sqliteandroid.data.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (application: Application): AndroidViewModel(application){

    val selectUsers: LiveData<List<Usuario>>
    val repository: UserRepository

    init{
        //verifica se existe instancia e a cria
        val userDao = UserDatabase.getDatabase(application).userDao()
        //passa a instancia para o repositório
        repository = UserRepository(userDao)
        selectUsers = repository.selectUsers
    }

    fun addUser(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUSer(usuario)
        }
    }
}