package dev.lchang.dpasemana09firebase.ui.fragments.client

import dev.lchang.dpasemana09firebase.ui.fragments.model.MascotaModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("mascotaperdida.php")
    fun listarMascota(): Call<List<MascotaModel>>
}