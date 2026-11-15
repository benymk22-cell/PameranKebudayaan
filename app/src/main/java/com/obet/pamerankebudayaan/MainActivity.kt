package com.obet.pamerankebudayaan

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var etUsia: EditText
    private lateinit var btnKirim: Button
    private lateinit var btnInfoEvent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNama = findViewById(R.id.etNama)
        etUsia = findViewById(R.id.etUsia)
        btnKirim = findViewById(R.id.btnKirim)
        btnInfoEvent = findViewById(R.id.btnInfoEvent)

        btnKirim.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val usiaText = etUsia.text.toString().trim()

            if (validasiInput(nama, usiaText)) {
                val usia = usiaText.toInt()

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra(ResultActivity.EXTRA_NAMA, nama)   // String
                    putExtra(ResultActivity.EXTRA_USIA, usia)   // Integer
                }
                startActivity(intent)
            }
        }

        btnInfoEvent.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"))
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Tidak ada aplikasi untuk membuka link", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validasiInput(nama: String, usiaText: String): Boolean {

        etNama.error = null
        etUsia.error = null

        if (nama.isEmpty() || usiaText.isEmpty()) {
            if (nama.isEmpty()) etNama.error = "Nama tidak boleh kosong"
            if (usiaText.isEmpty()) etUsia.error = "Usia tidak boleh kosong"
            Toast.makeText(this, "Mohon lengkapi semua data!", Toast.LENGTH_SHORT).show()
            return false
        }

        val usia = usiaText.toIntOrNull()
        if (usia == null || usia <= 0) {
            etUsia.error = "Masukkan usia berupa angka valid"
            Toast.makeText(this, "Usia harus berupa angka yang valid!", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}