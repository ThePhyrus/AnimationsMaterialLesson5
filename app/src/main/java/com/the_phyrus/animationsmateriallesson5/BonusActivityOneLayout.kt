package com.the_phyrus.animationsmateriallesson5

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.the_phyrus.animationsmateriallesson5.databinding.ActivityBonusOneLayoutBinding

class BonusActivityOneLayout : AppCompatActivity() {

    private lateinit var binding: ActivityBonusOneLayoutBinding
    private var isDescriptionShown: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBonusOneLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tap.setOnClickListener {
            val constraintSet = ConstraintSet()
            constraintSet.clone(binding.constraintContainer)
            val transitionChangeBounds = ChangeBounds()
            transitionChangeBounds.duration = 1000L
            transitionChangeBounds.interpolator = AnticipateOvershootInterpolator(3f)
            TransitionManager.beginDelayedTransition(
                binding.constraintContainer,
                transitionChangeBounds
            )
            isDescriptionShown = !isDescriptionShown
            if (isDescriptionShown){
                //show description
                constraintSet.connect(R.id.title, ConstraintSet.END, R.id.backgroundImage, ConstraintSet.END)
                constraintSet.connect(R.id.date, ConstraintSet.END, R.id.title, ConstraintSet.END)
                constraintSet.connect(R.id.description, ConstraintSet.TOP, R.id.tap, ConstraintSet.BOTTOM)
                binding.tap.text = "Hide description"
            }else {
                //hide description
                binding.tap.text = "Show description"
                constraintSet.connect(R.id.title, ConstraintSet.END, R.id.backgroundImage, ConstraintSet.START)
                constraintSet.connect(R.id.date, ConstraintSet.END, R.id.title, ConstraintSet.START)
                constraintSet.connect(R.id.description, ConstraintSet.TOP, R.id.backgroundImage, ConstraintSet.BOTTOM)
            }
            constraintSet.applyTo(binding.constraintContainer)
        }
    }
}