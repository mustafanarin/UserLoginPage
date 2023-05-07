package com.mustafanarin.userloginpage

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.mustafanarin.userloginpage.databinding.ActivityKayitOlBinding

class kayitOl : AppCompatActivity() {
    private lateinit var binding: ActivityKayitOlBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.btnKayitOl.setOnClickListener {
                if (binding.kullaniciGirisKayit.text.isNotEmpty() && binding.parolaGirisKayit.text.isNotEmpty()) {

                    var kullaniciAdi = binding.kullaniciGirisKayit.text.toString()
                    var parola = binding.parolaGirisKayit.text.toString().toInt()

                    sharedPreferences =
                        this.getSharedPreferences("com.mustafanarin.userloginpage", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()

                    editor.putString("kullanici", kullaniciAdi).apply()
                    editor.putInt("sifre", parola).apply()

                    Toast.makeText(this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show()

                    binding.kullaniciGirisKayit.text.clear()
                    binding.parolaGirisKayit.text.clear()
                }
                else{
                    Toast.makeText(this@kayitOl, "Lütfen kayıt bilgilerini giriniz!", Toast.LENGTH_SHORT).show()
                }
            }


        binding.btnGiriseDon.setOnClickListener {
            val intent = Intent(this@kayitOl,MainActivity::class.java)
            startActivity(intent)
        }


    }
}