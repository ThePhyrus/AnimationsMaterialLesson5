package com.the_phyrus

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.the_phyrus.animationsmateriallesson5.R
import com.the_phyrus.animationsmateriallesson5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transition = Explode()

        binding.rcView.adapter = Adapter()
    }



    inner class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_second_recycle_item,
                    parent,
                    false
                ) as View
            )
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            holder.itemView.setOnClickListener { button->
                //explode(it)
                val epicenter = Rect()
                button.getGlobalVisibleRect(epicenter)
                val transitionExplode = Explode()
                transitionExplode.epicenterCallback = object: Transition.EpicenterCallback(){
                    override fun onGetEpicenter(transition: Transition): Rect {
                        return epicenter
                    }
                }
                transitionExplode.duration = 5000
                transitionExplode.excludeTarget(button,true)
                val transitionFade = Fade().addTarget(button)
                val transitionSet = TransitionSet()
                transitionSet.addTransition(transitionExplode)
                transitionFade.duration = 10000
                transitionSet.addTransition(transitionFade)
                TransitionManager.beginDelayedTransition(binding.rcView,transitionSet)
                binding.rcView.adapter = null
            }
        }
        override fun getItemCount(): Int {
            return 20
        }

    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}