package com.the_phyrus

import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.ArcMotion
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.the_phyrus.animationsmateriallesson5.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding
    private var isTopLeftCorner: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonX.setOnClickListener {
            val transition = ChangeBounds()
            val path = ArcMotion()
            transition.setPathMotion(path)
            transition.duration = 3000
            TransitionManager.beginDelayedTransition(binding.root, transition)
            val params = (binding.buttonX.layoutParams as FrameLayout.LayoutParams)
            params.gravity = if (isTopLeftCorner) {
                Gravity.BOTTOM or Gravity.END
            } else {
                Gravity.TOP or Gravity.START
            }
            binding.buttonX.layoutParams = params
            isTopLeftCorner = !isTopLeftCorner
        }
    }
}