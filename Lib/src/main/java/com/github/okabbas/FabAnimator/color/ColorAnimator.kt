package com.github.okabbas.FabAnimator.color

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.support.design.widget.FloatingActionButton


internal class ColorAnimator(private val duration: Long, private val colorRange: IntArray) {

    //This is a method to change the background color with the Smooth model
    internal fun playBgTint(fab: FloatingActionButton): ValueAnimator {
        val valueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), *colorRange.toTypedArray())

        valueAnimator.duration = duration
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.REVERSE

        valueAnimator.addUpdateListener(ValueAnimator.AnimatorUpdateListener {
            fab.backgroundTintList = ColorStateList.valueOf(it.animatedValue as Int)
        })

        return valueAnimator
    }

    //This is a method to change the ICON color with the Smooth model
    internal fun playIconTint(fab: FloatingActionButton): ValueAnimator {
        val valueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), *colorRange.toTypedArray())

        valueAnimator.duration = duration
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.REVERSE

        valueAnimator.addUpdateListener(ValueAnimator.AnimatorUpdateListener {
            fab.setColorFilter(it.animatedValue as Int)
        })
        return valueAnimator
    }


    internal fun stopColoring(fab: FloatingActionButton, colorModel: ColorModel, colorOperation: Int) {
        if (colorModel == ColorModel.BG)
            fab.backgroundTintList = ColorStateList.valueOf(colorOperation)
        else fab.clearColorFilter()
    }
}