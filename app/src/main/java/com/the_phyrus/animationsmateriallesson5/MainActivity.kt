package com.the_phyrus.animationsmateriallesson5

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.*
import com.the_phyrus.animationsmateriallesson5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isGone: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAnimate.setOnClickListener {
            val transitionFade = Fade()
            transitionFade.duration = 3000

            val transitionChangeBounds = ChangeBounds()
            transitionChangeBounds.duration = 3000

            val transitionSet = TransitionSet()
            transitionSet.addTransition(transitionFade)
            transitionSet.addTransition(transitionChangeBounds)

            val transitionSlide = Slide(Gravity.END)
            transitionSlide.duration = 3000
            transitionSet.addTransition(transitionSlide)

//            TransitionManager.beginDelayedTransition(binding.transitionsContainer, transitionFade)
//            TransitionManager.beginDelayedTransition(binding.transitionsContainer, transitionChangeBounds)
            TransitionManager.beginDelayedTransition(binding.transitionsContainer, transitionSet)
            binding.tvText.visibility = if (isGone) {
                View.VISIBLE
            } else {
                View.GONE
            }
            isGone = !isGone
        }
    }
}