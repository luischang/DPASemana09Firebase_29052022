package dev.lchang.dpasemana09firebase.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import dev.lchang.dpasemana09firebase.R
import dev.lchang.dpasemana09firebase.ui.fragments.database.CustomerEntity

class CustomerFragment : Fragment() {

    companion object {
        fun newInstance() = CustomerFragment()
    }

    private lateinit var viewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =  inflater.inflate(R.layout.fragment_customer, container, false)

        val btnSaveDb: Button = view.findViewById(R.id.btnSaveDB)
        val txtFirstName: EditText = view.findViewById(R.id.txtFirstName)
        val txtLastName : EditText = view.findViewById(R.id.txtLastName)
        val txtPhone : EditText = view.findViewById(R.id.txtPhone)
        viewModel = ViewModelProvider(this)[CustomerViewModel::class.java]

        btnSaveDb.setOnClickListener {
            viewModel.saveCustomers(CustomerEntity(txtFirstName.text.toString(),txtLastName.text.toString(),txtPhone.text.toString()))
            viewCustomers()
        }
        return view
    }

    fun viewCustomers(){
        val observer = Observer<List<CustomerEntity>> { customers ->
            if (customers!=null){
                for(customer in customers){
                    Log.d("List Customer",customer.firstName + " " + customer.lastName + " " + customer.phone)
                }
            }
        }
        viewModel.customers.observe(viewLifecycleOwner,observer)
    }

}