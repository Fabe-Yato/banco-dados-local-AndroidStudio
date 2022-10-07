package com.cursokotlin.sqliteandroid.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//exportSchema - gera um script fora
@Database(entities = [Usuario::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        //Faz a variável ficar visivel para o app
        @Volatile
        private var INSTANCE: UserDatabase? = null

        //Verificar se existe uma instancia
        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            //ganha prioridade na thread que será executado
            synchronized(this){
                //Guarda a instancia do BD
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}