package dev.lchang.dpasemana09firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtCorreo = findViewById<EditText>(R.id.txtEmail)
        val txtClave: TextView = findViewById(R.id.txtPassword)
        val btnLogin: Button= findViewById(R.id.btnLogin)
        val db = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener{
            var correo: String = txtCorreo.text.toString()
            var clave: String = txtClave.text.toString()

            db.signInWithEmailAndPassword(correo, clave)
                .addOnCompleteListener(this){ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Autenticación exitosa",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,PrincipalActivity::class.java))
                    } else {
                        Toast.makeText(this,"Correo o Clave inválida",Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}