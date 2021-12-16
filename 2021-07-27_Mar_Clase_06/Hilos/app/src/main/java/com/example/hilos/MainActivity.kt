package com.example.hilos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var contador = 0
    var estado = true
    var pausa = false

    override fun onCreate(savedInstanceState: Bundle?) {

        var hilo=Hilo(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_iniciar.setOnClickListener {
                    hilo.start()
        }

        bt_pausar.setOnClickListener {
            pausa = true
        }

        bt_continuar.setOnClickListener {
            pausa = false
        }

        bt_reiniciar.setOnClickListener {
            contador = 0
        }

        bt_detener.setOnClickListener {
            if(hilo.isAlive) {
                estado = false
                return@setOnClickListener
            }
        }
    }


    class Hilo(activity:MainActivity):Thread() {
        var act = activity
        override fun run() {
            super.run()
            while (act.estado) {
                while (act.pausa == true) {
                    sleep(100)
                }
                sleep(100)
                act.runOnUiThread {
                    act.tv_contador.setText("Hilo: " + act.contador)
                }
                act.contador++
            }
        }
    }
}
