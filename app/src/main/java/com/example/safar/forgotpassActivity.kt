package com.example.safar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.safar.databinding.ActivityForgotpassBinding
import com.google.firebase.auth.FirebaseAuth

class forgotpassActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotpassBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotpassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.button3.setOnClickListener {

            val email = binding.emailRes.text.toString()
            if (email.isEmpty()) {

                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            } else {

                firebaseAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener {task ->

                        if(task.isSuccessful) {

                            Toast.makeText(this, "An Email Sent For Reset Your Password !!", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {

                            Toast.makeText(this,"Not Registered Yet!!", Toast.LENGTH_LONG).show()
                        }

                    }

            }
        }


    }

}