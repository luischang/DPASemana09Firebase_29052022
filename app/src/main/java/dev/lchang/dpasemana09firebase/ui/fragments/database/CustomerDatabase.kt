package dev.lchang.dpasemana09firebase.ui.fragments.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[CustomerEntity::class], version = 1)
abstract class CustomerDatabase: RoomDatabase() {
    abstract fun customerDao(): CustomerDao

    companion object {
        private const val DATABASE_NAME = "erp"
        @Volatile
        private var INSTANCE: CustomerDatabase?=null

        fun getInstance(context: Context): CustomerDatabase?{
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    CustomerDatabase::class.java,
                    DATABASE_NAME
                ).build()
                //).allowMainThreadQueries().build()
            }
            return INSTANCE
        }
    }
}