package com.example.factorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.example.factorial.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var n : Long = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var hilo = Hilo(this)

        bt_calcular_factorial.setOnClickListener {
            n = et_num.text.toString().toLong()
            if (hilo.isAlive) {
                return@setOnClickListener
            }
            hilo.start()
        }
    }
}


    class Hilo(activity:MainActivity):Thread() {
        var act = activity

        var factorial :Long = act.n
        override fun run() {
            super.run()
            if (act.n != null)
            {
                while (act.n > 1)
                {
                    log.d("Debug", "factorial = " + factorial)

                    factorial = factorial * (act.n - 1)
                        act.n = act.n - 1
                        //act.tv_factorial.text = factorial.toString()
                    act.runOnUiThread {
                        act.tv_factorial.setText(factorial.toString())
                    }
                }

            }

        }
    }