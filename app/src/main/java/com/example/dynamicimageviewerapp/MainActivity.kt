package com.example.dynamicimageviewerapp

import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.image_view)

        val buttonRed = findViewById<Button>(R.id.button_red)
        buttonRed.setOnClickListener {
            val currentDrawable = imageView.drawable
            val newDrawable = resources.getDrawable(R.drawable.image1_background, theme)
            crossfade(currentDrawable, newDrawable, imageView)
        }

        val buttonGreen = findViewById<Button>(R.id.button_green)
        buttonGreen.setOnClickListener {
            val currentDrawable = imageView.drawable
            val newDrawable = resources.getDrawable(R.drawable.image2_background, theme)
            crossfade(currentDrawable, newDrawable, imageView)
        }

        val buttonBlue = findViewById<Button>(R.id.button_blue)
        buttonBlue.setOnClickListener {
            val currentDrawable = imageView.drawable
            val newDrawable = resources.getDrawable(R.drawable.image3_background, theme)
            crossfade(currentDrawable, newDrawable, imageView)
        }
    }

    private fun crossfade(fromImage: Drawable, toImage: Drawable, imageView: ImageView) {
        val crossfadeTransition = TransitionDrawable(arrayOf(fromImage, toImage))
        imageView.setImageDrawable(crossfadeTransition)
        crossfadeTransition.startTransition(200) // Duration in milliseconds
    }
}
