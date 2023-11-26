package com.example.pim

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.pim.databinding.ActivityFormLoginBinding
import com.example.pim.ui.theme.TelaPrincipal
import com.google.android.material.snackbar.Snackbar
import android.util.Log

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RecSenha.setOnClickListener {
            Log.d("FormLogin", "Botão RecSenha clicado")
            val intent = Intent(this, RecSenha::class.java)
            startActivity(intent)
        }

        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#FFFFFF")

        binding.ButtonLogin.setOnClickListener {//validacao ao apertar o botao(Button_Login) de login
            val email = binding.EditEmail.text.toString()
            val password = binding.EditPassword.text.toString()

            when {
                email.isEmpty() -> {//erro por falta de Email
                    binding.EditEmail.error = "Preencha o Email!"
                }

                password.isEmpty() -> {//erro por falta da senha
                    binding.EditPassword.error = "Digite a senha!"
                }

                !email.contains("@gmail.com") -> {//validacao se tem o @gmail ou nao
                    val snackbar = Snackbar.make(
                        it,
                        "Email inválido!",
                        Snackbar.LENGTH_SHORT
                    )
                    snackbar.show()
                }

                password.length <= 5 -> {//erro senha inválida
                    val snackbar = Snackbar.make(
                        it,
                        "Senha inválida! A senha deve ter pelo menos 6 caracteres!",
                        Snackbar.LENGTH_SHORT
                    )
                    snackbar.show()
                }

                else -> {//mensagem logado com sucesso
                    login(it)
                }
            }
        }
    }

    private fun login(view: View) {//login
        binding.ButtonLogin.isEnabled = false //desabilita o botão(Button_Login) após clicar nele
        binding.ButtonLogin.setTextColor(Color.parseColor("#FFFFFF"))

        Handler(Looper.getMainLooper()).postDelayed({
            navegarTelaPrincipal()//Navega para a tela principal
            val snackbar = Snackbar.make(
                view,
                "Login efetuado com sucesso!",
                Snackbar.LENGTH_SHORT
            )
            snackbar.show()

            // Desbloqueia o botão após o atraso
            binding.ButtonLogin.isEnabled = true
            binding.ButtonLogin.setTextColor(Color.parseColor("#000000"))
        }, 3000)
    }

    private fun navegarTelaPrincipal() {//manda para tela principal
        val intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }
}
