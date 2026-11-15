package com.obet.pamerankebudayaan

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_USIA = "extra_usia"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        val nama = intent.getStringExtra(EXTRA_NAMA)
        val usia = intent.getIntExtra(EXTRA_USIA, 0)

        tvHasil.text = "Halo $nama, usia Anda $usia tahun.\n" +
                "Pendaftaran Pameran Seni dan Budaya berhasil!"

        Toast.makeText(this, "Selamat datang, $nama!", Toast.LENGTH_SHORT).show()

        btnKembali.setOnClickListener {
            finish()
        }
    }
}