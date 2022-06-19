package dev.lchang.dpasemana09firebase.ui.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import dev.lchang.dpasemana09firebase.ui.fragments.database.CustomerEntity
import dev.lchang.dpasemana09firebase.ui.fragments.database.CustomerRepository

class CustomerViewModel(application: Application) : AndroidViewModel(application) {
    private var repository = CustomerRepository(application)
    val customers = repository.getAll()

    fun saveCustomers(customerEntity: CustomerEntity){
        repository.insert(customerEntity)
    }
}