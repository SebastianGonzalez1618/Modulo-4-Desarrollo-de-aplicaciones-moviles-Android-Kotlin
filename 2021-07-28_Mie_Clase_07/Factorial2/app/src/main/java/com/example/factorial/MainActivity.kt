package com.example.factorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import kotlinx.android.synthetic.main.activity_main.*
import com.example.factorial.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    public lateinit var binding: ActivityMainBinding

    var n : Long = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        var hilo = Hilo(this)

        //bt_calcular_factorial.setOnClickListener {
        binding.btCalcularFactorial.setOnClickListener {
            //n = et_num.text.toString().toLong()
            n = binding.etNum.text.toString().toLong()
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
                    factorial *= (act.n - 1)
                        act.n = act.n - 1
                        //act.tv_factorial.text = factorial.toString()
                    act.runOnUiThread {
                        //act.tv_factorial.setText(factorial.toString())
                        act.binding.tvFactorial.setText(factorial.toString())
                    }
                }
                return
            }

        }
    }