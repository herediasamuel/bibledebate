package com.example.smarclarity.bible_ebate.view

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.smarclarity.bible_ebate.R
import java.io.IOException


class WelcomeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.begin)

        try{
            //Logo Animation
            Launcher_Display()

            val handler = Handler()
            handler.postDelayed(Runnable {



            }, 2000)

        }catch (e: IOException) {
            Log.e("LAUNCHER", "Error initializing.", e)
        }
    }

    private fun Launcher_Display(){
        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        //Text Animation
        val animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        val imageView = findViewById<View>(R.id.logo_launcher) as ImageView
        imageView.startAnimation(animation)
    }

}