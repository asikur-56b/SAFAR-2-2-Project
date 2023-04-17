package com.example.safar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.safar.databinding.ActivityMain1Binding
import com.example.safar.databinding.ActivityMainBinding


class MainActivity1 : AppCompatActivity() {

    private lateinit var  binding: ActivityMain1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main1)


        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceF(HomeFragment())
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment-> replaceF(HomeFragment())
                R.id.notificationFragment -> replaceF(NotificationFragment())

                R.id.infoFragment -> replaceF(InfoFragment())

                else -> {
                }
            }
            true
        }




    }

    private fun replaceF(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home, fragment)
        fragmentTransaction.commit()



    }





}