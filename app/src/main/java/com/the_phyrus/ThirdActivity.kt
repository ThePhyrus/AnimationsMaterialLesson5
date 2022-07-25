package com.the_phyrus

import android.os.Bundle

import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import com.the_phyrus.animationsmateriallesson5.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private var isMatchParent: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivAvatar.setOnClickListener {
            val params = (binding.ivAvatar.layoutParams as FrameLayout.LayoutParams)
            val transition = ChangeBounds()
            transition.duration = 500
            val transitionImage = ChangeImageTransform()
            transitionImage.duration = 500
            val transitionSet = TransitionSet()
            transitionSet.addTransition(transition)
            transitionSet.addTransition(transitionImage)
            TransitionManager.beginDelayedTransition(binding.container, transitionSet)
            if (isMatchParent) {
                params.height = FrameLayout.LayoutParams.WRAP_CONTENT
                binding.ivAvatar.scaleType = ImageView.ScaleType.CENTER_INSIDE
                binding.ivAvatar.layoutParams = params
            } else {
                params.height = FrameLayout.LayoutParams.MATCH_PARENT
                binding.ivAvatar.scaleType = ImageView.ScaleType.CENTER_CROP
                binding.ivAvatar.layoutParams = params
            }
            isMatchParent = !isMatchParent
        }
    }
}