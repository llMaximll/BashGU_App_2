package com.github.llmaximll.bashgu_app

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

private const val TIME_OUT: Long = 1000L

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        imageView = findViewById(R.id.image_view)

        animateView(imageView)

        loadSplashScreen()
    }

    private fun loadSplashScreen(){
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, TIME_OUT)
    }

    private fun animateView(view: View) {
        val objectAnimatorX = ObjectAnimator.ofFloat(
            view,
            "scaleX",
            1.2f
        )
        objectAnimatorX.duration = 800L
        objectAnimatorX.start()
        val objectAnimatorY = ObjectAnimator.ofFloat(
            view,
            "scaleY",
            1.2f
        )
        objectAnimatorY.duration = 800L
        objectAnimatorY.start()
        val objectAnimatorAlpha = ObjectAnimator.ofFloat(
            view,
            "alpha",
            1.0f
        )
        objectAnimatorAlpha.duration = 500L
        objectAnimatorAlpha.start()
    }
}