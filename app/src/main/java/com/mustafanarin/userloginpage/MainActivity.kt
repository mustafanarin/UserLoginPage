package com.mustafanarin.userloginpage

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mustafanarin.userloginpage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("com.mustafanarin.userloginpage", MODE_PRIVATE)
        binding.btnGiris.setOnClickListener {
            var kullaniciGiris = binding.kullaniciGiris.text.toString()
            var parolaGiris = binding.parolaGiris.text.toString().toInt()

            var kullaniciKayit = sharedPreferences.getString("kullanici","")
            var parolaKayit = sharedPreferences.getInt("sifre",-1)

            if ((kullaniciKayit == kullaniciGiris) && (parolaKayit == parolaGiris)){
                val intent = Intent(this@MainActivity,hosgeldiniz::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Hatalı Giriş!", Toast.LENGTH_SHORT).show()
            }


        }

        binding.btnKayit.setOnClickListener {
            val intent = Intent(this@MainActivity,kayitOl::class.java)
            startActivity(intent)
        }

       
    }
}