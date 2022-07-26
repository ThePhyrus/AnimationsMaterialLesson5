package com.the_phyrus.animationsmateriallesson5

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.the_phyrus.animationsmateriallesson5.databinding.ActivityAnimationsBonusStartBinding

class BonusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationsBonusStartBinding
    private var isPressed: Boolean = false
    private val duration: Long = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBonusStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tap.setOnClickListener {
            isPressed = !isPressed
            val constraintSet = ConstraintSet()
            val transition = ChangeBounds()
            transition.duration = duration
            transition.interpolator = AnticipateOvershootInterpolator(3f)
            TransitionManager.beginDelayedTransition(binding.constraintContainer, transition)
            if (isPressed) {
                binding.tap.text = "Hide description"
                constraintSet.clone(this, R.layout.activity_animations_bonus_end)
                constraintSet.applyTo(binding.constraintContainer)
            } else {
                binding.tap.text = "Show description"
                constraintSet.clone(this, R.layout.activity_animations_bonus_start)
                constraintSet.applyTo(binding.constraintContainer)
            }
        }
    }
}