package com.example.toolpwa


//@file:Suppress("DEPRECATION")
import android.annotation.SuppressLint
import android.app.AlertDialog.Builder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.toolpwa.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webWiew = binding.webView


        webWiew.loadUrl("https://app.govmei.com.br/#/")
        webWiew.settings.javaScriptEnabled = true
        webWiew.settings.domStorageEnabled = true

    }


    override fun onBackPressed() {
        //super.onBackPressed()
        autorisandoSaida();
    }

    private fun autorisandoSaida(){

        val builder = Builder(this)

        builder.setIcon(R.mipmap.ic_launcher)
        builder.setTitle(R.string.app_name)
        builder.setMessage("Voce Deseja sair do GOVMEI?")
        builder.setCancelable(false)
        builder.setPositiveButton("Sim") { dialog, x -> this.finish() }
        builder.setNegativeButton("Não") { dialog, x -> dialog.cancel() }
        val alert = builder.create()
        alert.show()


    }




}
