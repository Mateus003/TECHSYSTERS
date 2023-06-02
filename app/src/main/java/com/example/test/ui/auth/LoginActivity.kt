package com.example.test.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test.R
import com.example.test.databinding.ActivityLoginBinding
import com.example.test.ui.IntroductionActivity
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textRecover.setOnClickListener(this)
        binding.textRegister.setOnClickListener(this)
        binding.buttonAccess.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        if (v.id == R.id.text_recover) {
            startActivity(Intent(this, RecoverActivity::class.java))
        } else if (v.id == R.id.text_register) {
            startActivity(Intent(this, RegisterActivity::class.java))
        } else if (v.id == R.id.button_access) {
            val email =binding.editTextEmail.toString()
            val password = binding.editTextPassword.toString()

            if (email != "" && password != ""){
                startActivity(Intent(this, IntroductionActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Não deixe os campos vazios", Toast.LENGTH_LONG).show()
            }
        }

    }




}