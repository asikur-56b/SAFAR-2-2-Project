package com.example.safar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.safar.databinding.ActivityMain1Binding
import com.example.safar.databinding.ActivityMain2Binding

import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {

    private lateinit var  binding: ActivityMain2Binding
    private lateinit var  firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()



        binding.logoutbtn.setOnClickListener(){
            firebaseAuth.signOut()
            checkUser()
        }

    }


    private fun checkUser(){


        val firebaseUser = firebaseAuth.currentUser

        if(firebaseUser!=null){
            //user not null,user is logged in
            val email = firebaseUser.email
            //set to text view

            binding.emailTv.text = email

        }else{
            //user is null,user is not loggedin
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }

}

