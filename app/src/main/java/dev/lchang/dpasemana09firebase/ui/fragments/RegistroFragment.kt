package dev.lchang.dpasemana09firebase.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import dev.lchang.dpasemana09firebase.R
import dev.lchang.dpasemana09firebase.ui.fragments.model.CourseModel
import java.util.*


class RegistroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registro, container, false)
        val txtDescription: EditText = view.findViewById(R.id.txtDescription)
        val txtScore: EditText = view.findViewById(R.id.txtScore)
        val btnSave: Button = view.findViewById(R.id.btnSave)
        val db = FirebaseFirestore.getInstance()

        btnSave.setOnClickListener{
            var description = txtDescription.text.toString()
            var score = txtScore.text.toString()

            val newCourse = CourseModel(description,score)
            val newID: String = UUID.randomUUID().toString()

            db.collection("courses")
                .document(newID)
                .set(newCourse)
                .addOnSuccessListener {
                    Snackbar.make(view,"Se registró correctamente",Snackbar.LENGTH_LONG).show()
                }.addOnFailureListener{
                    Snackbar.make(view,"Error al registrar el curso....",Snackbar.LENGTH_LONG).show()
                }
        }
        return view
    }
}