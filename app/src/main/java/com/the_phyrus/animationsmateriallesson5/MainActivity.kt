package com.the_phyrus.animationsmateriallesson5

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.the_phyrus.animationsmateriallesson5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isGone: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAnimate.setOnClickListener {
            binding.tvText.visibility = if (isGone) {
                View.VISIBLE
            } else {
                View.GONE
            }
            isGone = !isGone
        }

    }
}