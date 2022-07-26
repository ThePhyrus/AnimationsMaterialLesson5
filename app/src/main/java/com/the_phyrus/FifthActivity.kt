package com.the_phyrus

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.the_phyrus.animationsmateriallesson5.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding
    private var isTrue: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            isTrue = !isTrue
            if (isTrue) {
                ObjectAnimator.ofFloat(binding.fab, View.ROTATION, 0f, -180f).start()
            } else {
                ObjectAnimator.ofFloat(binding.fab, View.ROTATION, -180f, 0f).start()
            }

        }

    }
}