package com.example.pim

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pim.databinding.ActivityFormLoginBinding // Correct import
import com.example.pim.ui.theme.TelaPrincipal
import com.google.android.material.snackbar.Snackbar

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#FFFFFF")

        binding.ButtonLogin.setOnClickListener{//validacao ao apertar o botao(Button_Login) de login

            val email = binding.EditEmail.text.toString()
            val password = binding.EditPassword.text.toString()

            when{
                email.isEmpty() -> {//erro por falta de Emal
                    binding.EditEmail.error = "Preencha o Email!"
                }
                password.isEmpty() ->{//erro por falto da senha
                    binding.EditPassword.error = "Digite a senha!"
                }
                !email.contains("@gmail.com") -> {//validacao se tem o @gmail ou nao
                    val snackbar = Snackbar.make(it,"Email invalido!",Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
                password.length <= 5 ->{//erro senha invalida
                    val snackbar = Snackbar.make(it,"Senha invalida! A senha tem pelo menos 6 caracteres!",Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
                else ->{//mensagem logao com sucesso
                login(it)
                }
            }
        }
    }
    private fun login(view: View){//login
        binding.ButtonLogin.isEnabled = false //desabilita o botao(Button_Login) apos clicar nele
        binding.ButtonLogin.setTextColor(Color.parseColor("#FFFFFF"))

        Handler(Looper.getMainLooper()).postDelayed({
            navegarTelaPrincipal()//Navega para a tela principal
            val snackbar = Snackbar.make(view,"Login efetuado com sucesso!",Snackbar.LENGTH_SHORT)
            snackbar.show()

            // Desbloqueia o botão após o atraso
            binding.ButtonLogin.isEnabled = true
            binding.ButtonLogin.setTextColor(Color.parseColor("#000000"))
        },3000)
    }

    private fun navegarTelaPrincipal(){//manda para tela principal
        val intent = Intent(this,TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }

    class FormLogin : AppCompatActivity() {

        private lateinit var recuperarCadastro: TextView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_rec_senha)

            recuperarCadastro.setOnClickListener {
                val intent = Intent(this@FormLogin, RecSenha::class.java)
                startActivity(intent)
            }
        }

    }




}

