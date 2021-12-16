package com.example.bottomnavigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val taxiFragment = TaxiFragment()
    val avionFragment = AvionFragment()
    val barcoFragment = BarcoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Debug", "MainActivity > 1")
        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        reemplazar(taxiFragment)
        Log.d("Debug", "MainActivity > 2")
        bottom_navigation.setOnItemSelectedListener {
            Log.d("Debug", "MainActivity > 3")
            when(it.itemId){
                R.id.taxi -> reemplazar(taxiFragment)
                R.id.avion -> reemplazar(avionFragment)
                R.id.barco -> reemplazar(barcoFragment)
            }
            Log.d("Debug", "MainActivity > 5")
            true
        }
    }


    fun reemplazar(fragment: Fragment) {
        Log.d("Debug", "MainActivity > 1")
        if (fragment != null) {
            Log.d("Debug", "MainActivity > 2")
            val transaccion = supportFragmentManager.beginTransaction()
            Log.d("Debug", "MainActivity > 3")
            transaccion.commit()
        }
    }
}