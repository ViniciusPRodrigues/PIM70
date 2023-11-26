package com.example.pim.ui.theme

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pim.R

class TelaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)
        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#FFFFFF")
    }
}