package dev.lchang.dpasemana09firebase.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.lchang.dpasemana09firebase.R
import dev.lchang.dpasemana09firebase.ui.fragments.adapter.MascotaAdapter
import dev.lchang.dpasemana09firebase.ui.fragments.client.MascotaClient
import dev.lchang.dpasemana09firebase.ui.fragments.model.MascotaModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MascotaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_mascota, container, false)

        val rvMascota: RecyclerView = view.findViewById(R.id.rvMascota)
        rvMascota.layoutManager = LinearLayoutManager(requireActivity())

        var request: Call<List<MascotaModel>>
                = MascotaClient.retrofitService.listarMascota()

        request.enqueue(object: Callback<List<MascotaModel>>{
            override fun onResponse(
                call: Call<List<MascotaModel>>,
                response: Response<List<MascotaModel>>
            ) {
                rvMascota.adapter = MascotaAdapter(response.body()!!)
            }

            override fun onFailure(call: Call<List<MascotaModel>>, t: Throwable) {
                Toast.makeText(requireContext(),"Error al cargar las mascotas",Toast.LENGTH_LONG).show()
            }
        })
        return view
    }

}