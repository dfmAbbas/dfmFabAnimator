package com.github.dfmabbas.animator.color

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.res.ColorStateList
import com.google.android.material.floatingactionbutton.FloatingActionButton


internal class ColorAnimator(private val duration: Long, private val colorRange: IntArray) {
    fun playBgTint(fab: FloatingActionButton): ValueAnimator {
        val valueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), *colorRange.toTypedArray())

        valueAnimator.duration = duration
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.REVERSE

        valueAnimator.addUpdateListener {
            fab.backgroundTintList = ColorStateList.valueOf(it.animatedValue as Int)
        }

        return valueAnimator
    }

    fun playIconTint(fab: FloatingActionButton): ValueAnimator {
        val valueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), *colorRange.toTypedArray())

        valueAnimator.duration = duration
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.REVERSE

        valueAnimator.addUpdateListener {
            fab.setColorFilter(it.animatedValue as Int)
        }
        return valueAnimator
    }


    fun stopColoring(fab: FloatingActionButton, fabColor: ColorStateList) {
        fab.backgroundTintList = fabColor
        fab.clearColorFilter()
    }
}