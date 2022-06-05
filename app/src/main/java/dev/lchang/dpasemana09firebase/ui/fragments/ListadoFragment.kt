package dev.lchang.dpasemana09firebase.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import dev.lchang.dpasemana09firebase.R
import dev.lchang.dpasemana09firebase.ui.fragments.adapter.CourseAdapter
import dev.lchang.dpasemana09firebase.ui.fragments.model.CourseModel

class ListadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_listado, container, false)
        val db = FirebaseFirestore.getInstance()
        val lstCourses: ArrayList<CourseModel> = ArrayList()
        val rvCourse: RecyclerView = view.findViewById(R.id.rvCourse)

        db.collection("courses")
            .addSnapshotListener{snapshots, e->
                if(e!=null){
                    Log.e("Firebase Error","Ocurrió un error al cargar los cursos")
                    return@addSnapshotListener
                }

                for(dc in snapshots!!.documentChanges){
                    when(dc.type){
                        DocumentChange.Type.ADDED,
                            DocumentChange.Type.MODIFIED,
                            DocumentChange.Type.REMOVED ->{
                                lstCourses.add(
                                    CourseModel(dc.document.data["description"].toString(),
                                                dc.document.data["score"].toString())
                                )
                            }
                    }
                }
                rvCourse.adapter = CourseAdapter(lstCourses)
                rvCourse.layoutManager = LinearLayoutManager(requireContext())

            }


        return view
    }

}