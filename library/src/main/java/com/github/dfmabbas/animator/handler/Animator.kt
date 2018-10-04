package com.github.dfmabbas.animator.handler

import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import com.github.dfmabbas.animator.anim.AnimAnimator
import com.github.dfmabbas.animator.anim.AnimModel
import com.github.dfmabbas.animator.color.ColorAnimator
import com.github.dfmabbas.animator.color.ColorModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Animator {
    private var colorAnimator: ColorAnimator? = null
    private var animAnimator: AnimAnimator? = null
    private var valueColor: ValueAnimator? = null
    private var valueAnim: ValueAnimator? = null

    private lateinit var fabAnimator: FloatingActionButton
    private lateinit var correctedRange: IntArray
    private lateinit var fabColor: ColorStateList

    fun playOn(fab: FloatingActionButton): Animator {
        fabAnimator = fab
        fabColor = fab.backgroundTintList!!

        return this
    }

    fun setAnimation(animModel: AnimModel = AnimModel.JUMP, duration: Long = 800): Animator {
        valueAnim?.let { if (it.isRunning) return this }

        //Singleton
        if (animAnimator == null) animAnimator = AnimAnimator(duration)

        valueAnim = when (animModel) {
            AnimModel.JUMP -> animAnimator?.playJumpAnim(fabAnimator)
            AnimModel.BLINKER -> animAnimator?.playBlinkerAnim(fabAnimator)
            AnimModel.SHAKE -> animAnimator?.playShakeAnim(fabAnimator)
        }

        return this
    }

    fun setColoring(colorModel: ColorModel = ColorModel.BG, duration: Long = 800,
                    colorRange: IntArray = intArrayOf(Color.MAGENTA, Color.RED)): Animator {

        valueColor?.let { if (it.isRunning) return this }

        correctedRange =
                if (colorRange.size <= 1) intArrayOf(Color.MAGENTA, colorRange[colorRange.size])
                else colorRange

        //Singleton
        if (colorAnimator == null) colorAnimator = ColorAnimator(duration, correctedRange)

        valueColor = when (colorModel) {
            ColorModel.ICON -> colorAnimator?.playIconTint(fabAnimator)
            ColorModel.BG -> colorAnimator?.playBgTint(fabAnimator)
        }

        return this
    }


    fun start() {
        valueAnim?.startValue()
        valueColor?.startValue()
    }

    fun stop() {
        valueAnim?.stopValue()
        valueColor?.stopValue()

        animAnimator?.stopAnimation(fabAnimator)
        colorAnimator?.stopColoring(fabAnimator, fabColor)
    }

    private fun ValueAnimator.stopValue() {
        if (!this.isRunning) return
        this.cancel()
        this.end()
    }

    private fun ValueAnimator.startValue() {
        if (this.isRunning) return
        this.start()
    }
}