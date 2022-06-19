package dev.lchang.dpasemana09firebase.ui.fragments.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CustomerDao {
    @Insert
    fun insert(customerEntity: CustomerEntity)
    @Update
    fun update(customerEntity: CustomerEntity)
    @Delete
    fun delete(customerEntity: CustomerEntity)
    @Query("SELECT * FROM customer ORDER BY id desc")
    fun getCustomer(): LiveData<List<CustomerEntity>>
}