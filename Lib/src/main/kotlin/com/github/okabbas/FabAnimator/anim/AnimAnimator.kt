package com.github.okabbas.FabAnimator.anim

import android.animation.ValueAnimator
import android.support.design.widget.FloatingActionButton
import android.view.animation.AccelerateInterpolator

internal class AnimAnimator(private val duration: Long) {

    internal fun playScale(fab: FloatingActionButton): ValueAnimator {
        val valueAnimator = ValueAnimator.ofFloat(fab.scaleX + 0.10F, fab.scaleX, fab.scaleX + 0.07F, fab.scaleX)
        valueAnimator.addUpdateListener {
            fab.scaleX = it.animatedValue as Float
            fab.scaleY = it.animatedValue as Float
        }

        valueAnimator.interpolator = AccelerateInterpolator(1F)
        valueAnimator.duration = 600
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.REVERSE

        return valueAnimator
    }

    internal fun playAlpha(fab: FloatingActionButton): ValueAnimator {
        val valueAnimator = ValueAnimator.ofFloat(fab.alpha - 1F, fab.alpha)
        valueAnimator.addUpdateListener {
            fab.alpha = it.animatedValue as Float
        }

        valueAnimator.interpolator = AccelerateInterpolator(1F)
        valueAnimator.duration = duration
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.REVERSE

        return valueAnimator
    }

    fun stopAnimation(fab: FloatingActionButton) {
        fab.clearAnimation()
    }
}