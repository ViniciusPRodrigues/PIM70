package com.example.pim

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pim.databinding.ActivityRecSenhaBinding
import com.google.android.material.snackbar.Snackbar

class RecSenha : AppCompatActivity() {
    private lateinit var binding: ActivityRecSenhaBinding // Declare o objeto de binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonVoltar.setOnClickListener {
            Log.d("RecSenha", "Botão Voltar clicado")
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
        }

        binding.ButtonRecSenha.setOnClickListener {
            // validação ao apertar o botão ButtonRecSenha
            val email = binding.EditEmail.text.toString()

            when {
                email.isEmpty() -> {
                    binding.EditEmail.error = "Preencha o Email!"
                }
                !email.contains("@gmail.com") -> {
                    val snackbar = Snackbar.make(
                        it,
                        "Email inválido!",
                        Snackbar.LENGTH_SHORT
                    )
                    snackbar.show()
                }
                else -> {
                    // Exemplo: enviar um e-mail de recuperação de senha
                    val snackbar = Snackbar.make(
                        it,
                        "Senha recuperada com sucesso!",
                        Snackbar.LENGTH_SHORT
                    )
                    snackbar.show()
                }
            }
        }
    }
}
