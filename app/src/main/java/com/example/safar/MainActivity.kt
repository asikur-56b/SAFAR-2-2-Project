package com.example.safar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import java.util.*
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nayem = findViewById<LottieAnimationView>(R.id.lottie)
        Handler(Looper.getMainLooper()).postDelayed({

            nayem.visibility = View.VISIBLE
            nayem.playAnimation()
        }, 0)
        nayem.animate().translationX(0F).setDuration(2100).setStartDelay(2900);
        startsecond();


    }


    fun startsecond() {

        if (!isDestroyed) {
            val intent = Intent(this, SignInActivity::class.java)
            val tmtask = timerTask {
                if (!isDestroyed) {
                    startActivity(intent)
                    finish()
                }
            }
            val timer = Timer()
            timer.schedule(tmtask, 2000)


        }
    }
}

    