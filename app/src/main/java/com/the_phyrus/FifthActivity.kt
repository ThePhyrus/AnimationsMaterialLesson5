package com.the_phyrus

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.the_phyrus.animationsmateriallesson5.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding
    private var isTrue: Boolean = false
    private val duration: Long = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            isTrue = !isTrue
            if (isTrue) {
                ObjectAnimator.ofFloat(binding.fab, View.ROTATION, 0f, 540f).setDuration(duration)
                    .start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, -130f)
                    .setDuration(duration)
                    .start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, -250f)
                    .setDuration(duration)
                    .start()
            } else {
                ObjectAnimator.ofFloat(binding.fab, View.ROTATION, 540f, 0f).setDuration(duration)
                    .start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, 0f)
                    .setDuration(duration)
                    .start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, 0f)
                    .setDuration(duration)
                    .start()
            }

        }

    }
}