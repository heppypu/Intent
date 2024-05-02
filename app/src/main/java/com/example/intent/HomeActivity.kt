package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity(),View.OnClickListener{
    lateinit var btnExplisit : Button
    lateinit var btnImplisit : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnExplisit = findViewById(R.id.btnExplisit)
        btnImplisit = findViewById(R.id.btnImplisit)

        btnExplisit.setOnClickListener(this)
        btnImplisit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnExplisit -> {
                // tempat intent nya (fungsi intent dijalankan dalam aksi button)
                val intentExplisit = Intent(this@HomeActivity, PageActivity2::class.java)
                //Run intent (untuk menjalankan a)
                startActivity(intentExplisit)
            }
            R.id.btnImplisit ->{
                val intentImplisit = Intent(this@HomeActivity, DialActivity::class.java).also{
                    startActivity(it)
                }
            }
        }
    }
}