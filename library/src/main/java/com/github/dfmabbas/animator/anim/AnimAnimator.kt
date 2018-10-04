package com.github.dfmabbas.animator.anim

import android.animation.ValueAnimator
import android.view.animation.AccelerateInterpolator
import com.google.android.material.floatingactionbutton.FloatingActionButton


internal class AnimAnimator(private val duration: Long) {
    fun playJumpAnim(fab: FloatingActionButton): ValueAnimator {
        val scale = fab.scaleX

        val valueAnimator = ValueAnimator.ofFloat(scale, scale + 0.2F
                , scale + 0.1F, scale)

        valueAnimator.addUpdateListener {
            fab.scaleX = it.animatedValue as Float
            fab.scaleY = it.animatedValue as Float
        }

        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.REVERSE
        valueAnimator.interpolator = AccelerateInterpolator(3F)
        valueAnimator.duration = duration

        return valueAnimator
    }

    fun playBlinkerAnim(fab: FloatingActionButton): ValueAnimator {
        val valueAnimator = ValueAnimator.ofFloat(fab.alpha, fab.alpha - 1F, fab.alpha)
        valueAnimator.addUpdateListener {
            fab.alpha = it.animatedValue as Float
        }

        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.REVERSE
        valueAnimator.interpolator = AccelerateInterpolator(2F)
        valueAnimator.duration = duration

        return valueAnimator
    }

    fun playShakeAnim(fab: FloatingActionButton): ValueAnimator {
        val valueAnimator = ValueAnimator.ofFloat(fab.scaleX, fab.scaleX + 0.1F, fab.scaleX
                , fab.scaleX + 0.1F, fab.scaleX)

        valueAnimator.addUpdateListener {
            fab.scaleX = it.animatedValue as Float
            fab.scaleY = it.animatedValue as Float
        }

        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.REVERSE
        valueAnimator.interpolator = AccelerateInterpolator(3F)
        valueAnimator.duration = duration

        return valueAnimator
    }

    fun stopAnimation(fab: FloatingActionButton) {
        fab.clearAnimation()
    }
}