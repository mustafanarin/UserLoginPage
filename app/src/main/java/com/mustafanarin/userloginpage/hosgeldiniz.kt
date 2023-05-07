package com.mustafanarin.userloginpage

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mustafanarin.userloginpage.databinding.ActivityHosgeldinizBinding

class hosgeldiniz : AppCompatActivity() {
    private lateinit var binding: ActivityHosgeldinizBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHosgeldinizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("com.mustafanarin.userloginpage", MODE_PRIVATE)

        val kullanici = sharedPreferences.getString("kullanici","")
        val parola = sharedPreferences.getInt("sifre",-1)

        binding.kullaniciAdiText.text = "Kullanıcı Adı: "+kullanici
        binding.parolaText.text = "Parola: " +parola

        binding.btnCikis.setOnClickListener {
            val intent = Intent(this@hosgeldiniz,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}