package dev.lchang.dpasemana09firebase.ui.fragments.database

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CustomerRepository(application: Application) {
    private val customerDao: CustomerDao?= CustomerDatabase.getInstance(application)?.customerDao()

   /* fun insert(customerEntity: CustomerEntity){
        if(customerEntity!=null)
            customerDao?.insert(customerEntity)
    }*/

    fun insert(customerEntity: CustomerEntity){
        if(customerEntity!=null)
            customerDao?.let { InsertAsyncTask(it).execute(customerEntity) }
    }

    fun getAll(): LiveData<List<CustomerEntity>>{
        return customerDao?.getCustomer() ?: MutableLiveData<List<CustomerEntity>>()
    }

    private class InsertAsyncTask(private val customerDao: CustomerDao): AsyncTask<CustomerEntity,Void,Void>(){
        override fun doInBackground(vararg customers: CustomerEntity?): Void? {
            for(customer in customers){
                if(customer!=null) customerDao.insert(customer)
            }
            return null
        }
    }



}