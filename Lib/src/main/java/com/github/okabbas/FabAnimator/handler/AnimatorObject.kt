package com.github.okabbas.FabAnimator.handler

import android.animation.ValueAnimator
import android.graphics.Color
import android.support.design.widget.FloatingActionButton
import com.github.okabbas.FabAnimator.anim.AnimAnimator
import com.github.okabbas.FabAnimator.anim.AnimModel
import com.github.okabbas.FabAnimator.anim.AnimModel.*
import com.github.okabbas.FabAnimator.color.ColorAnimator
import com.github.okabbas.FabAnimator.color.ColorModel

class AnimatorObject {
    private var colorAnimator: ColorAnimator? = null
    private var animAnimator: AnimAnimator? = null

    private var valueColor: ValueAnimator? = null
    private var valueAnim: ValueAnimator? = null

    private var fabAnimator: FloatingActionButton? = null

    private lateinit var correctedRange: IntArray

    fun create(fab: FloatingActionButton) {
        fabAnimator = fab
    }

    fun setAnimation(animModel: AnimModel = JUMP, duration: Long = 800) {
        valueAnim?.let { if (it.isRunning) return }

        //Singleton
        if (animAnimator == null) animAnimator = AnimAnimator(duration)

        valueAnim = when (animModel) {
            JUMP -> animAnimator?.playJumpAnim(fabAnimator!!)
            BLINKER -> animAnimator?.playBlinkerAnim(fabAnimator!!)
            SHAKE -> animAnimator?.playtest1(fabAnimator!!)
        }
    }

    fun setColoring(colorModel: ColorModel = ColorModel.BG, duration: Long = 800,
                    colorRange: IntArray = intArrayOf(Color.MAGENTA, Color.RED)) {

        valueColor?.let { if (it.isRunning) return }

        correctedRange =
                if (colorRange.size <= 1) intArrayOf(Color.MAGENTA, colorRange[colorRange.size])
                else colorRange

        //Singleton
        if (colorAnimator == null) colorAnimator = ColorAnimator(duration, correctedRange)

        valueColor = when (colorModel) {
            ColorModel.ICON -> colorAnimator?.playIconTint(fabAnimator!!)
            ColorModel.BG -> colorAnimator?.playBgTint(fabAnimator!!)
        }
    }


    fun start() {
        valueAnim?.startAnimation()
        valueColor?.startAnimation()
    }

    fun stopColoring(colorModel: ColorModel = ColorModel.BG, colorOperation: Int = Color.MAGENTA) {
        valueColor?.stopAnimation()
        colorAnimator?.stopColoring(fabAnimator!!, colorModel, colorOperation)

        valueColor = null
        colorAnimator = null
    }

    fun stopAnimation() {
        valueAnim?.stopAnimation()
        animAnimator?.stopAnimation(fabAnimator!!)

        valueAnim = null
        animAnimator = null
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