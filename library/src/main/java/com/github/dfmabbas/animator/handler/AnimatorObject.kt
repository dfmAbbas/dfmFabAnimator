package com.github.dfmabbas.animator.handler

import android.animation.ValueAnimator
import android.graphics.Color
import android.support.design.widget.FloatingActionButton
import com.github.dfmabbas.anim.AnimModel
import com.github.dfmabbas.animator.anim.AnimAnimator
import com.github.dfmabbas.animator.color.ColorAnimator
import com.github.dfmabbas.animator.color.ColorModel

class AnimatorObject {
    private var colorAnimator: ColorAnimator? = null
    private var animAnimator: AnimAnimator? = null

    private var valueColor: ValueAnimator? = null
    private var valueAnim: ValueAnimator? = null

    private var fabAnimator: FloatingActionButton? = null

    private lateinit var correctedRange: IntArray

    fun create(fab: FloatingActionButton): AnimatorObject {
        fabAnimator = fab

        return this
    }

    fun setAnimation(animModel: AnimModel = AnimModel.JUMP, duration: Long = 800): AnimatorObject {
        valueAnim?.let { if (it.isRunning) return this }

        //Singleton
        if (animAnimator == null) animAnimator = AnimAnimator(duration)

        valueAnim = when (animModel) {
            AnimModel.JUMP -> animAnimator?.playJumpAnim(fabAnimator!!)
            AnimModel.BLINKER -> animAnimator?.playBlinkerAnim(fabAnimator!!)
            AnimModel.SHAKE -> animAnimator?.playShakeAnim(fabAnimator!!)
        }

        return this
    }

    fun setColoring(colorModel: ColorModel = ColorModel.BG, duration: Long = 800,
                    colorRange: IntArray = intArrayOf(Color.MAGENTA, Color.RED)): AnimatorObject {

        valueColor?.let { if (it.isRunning) return this }

        correctedRange =
                if (colorRange.size <= 1) intArrayOf(Color.MAGENTA, colorRange[colorRange.size])
                else colorRange

        //Singleton
        if (colorAnimator == null) colorAnimator = ColorAnimator(duration, correctedRange)

        valueColor = when (colorModel) {
            ColorModel.ICON -> colorAnimator?.playIconTint(fabAnimator!!)
            ColorModel.BG -> colorAnimator?.playBgTint(fabAnimator!!)
        }

        return this
    }


    fun start(): AnimatorObject {
        valueAnim?.startAnimation()
        valueColor?.startAnimation()

        return this
    }

    fun stopColoring(colorModel: ColorModel = ColorModel.BG, colorOperation: Int = Color.MAGENTA): AnimatorObject {
        valueColor?.stopAnimation()
        colorAnimator?.stopColoring(fabAnimator!!, colorModel, colorOperation)

        valueColor = null
        colorAnimator = null

        return this
    }

    fun stopAnimation(): AnimatorObject {
        valueAnim?.stopAnimation()
        animAnimator?.stopAnimation(fabAnimator!!)

        valueAnim = null
        animAnimator = null

        return this
    }

    private fun ValueAnimator.stopAnimation() {
        if (!this.isRunning) return
        this.cancel()
        this.end()
    }

    private fun ValueAnimator.startAnimation() {
        if (this.isRunning) return
        this.start()
    }
}