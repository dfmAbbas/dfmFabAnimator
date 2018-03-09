package com.github.okabbas.FabAnimator.handler

import android.animation.ValueAnimator
import android.graphics.Color
import android.support.design.widget.FloatingActionButton
import com.github.okabbas.FabAnimator.anim.AnimAnimator
import com.github.okabbas.FabAnimator.anim.AnimModel
import com.github.okabbas.FabAnimator.anim.AnimModel.Alpha
import com.github.okabbas.FabAnimator.anim.AnimModel.Scale
import com.github.okabbas.FabAnimator.color.ColorAnimator
import com.github.okabbas.FabAnimator.color.ColorModel
import com.github.okabbas.FabAnimator.color.ColorModel.*

class AnimatorObject(private val fab: FloatingActionButton) {
    private var colorAnimator: ColorAnimator? = null
    private var animAnimator: AnimAnimator? = null

    private var valueColor: ValueAnimator? = null
    private var valueAnim: ValueAnimator? = null

    private lateinit var correctedRange: IntArray

    fun createAnimator(colorModel: ColorModel = Background,
                       animModel: AnimModel = AnimModel.None,
                       duration: Long = 800,
                       colorRange: IntArray = intArrayOf(Color.MAGENTA, Color.RED)) {

        valueColor?.let { if (it.isRunning) return }
        valueAnim?.let { if (it.isRunning) return }

        //if (valueColor?.isRunning || valueAnim?.isRunning!!) return

        correctedRange =
                if (colorRange.size <= 1) intArrayOf(Color.MAGENTA, colorRange[colorRange.size])
                else colorRange

        if (animAnimator == null) animAnimator = AnimAnimator(duration)
        if (colorAnimator == null) colorAnimator = ColorAnimator(duration, correctedRange)

        valueColor = when (colorModel) {
            Icon -> colorAnimator?.playInIcon(fab)
            Background -> colorAnimator?.playInBackground(fab)
            None -> null
        }

        valueColor?.startAnimation()

        valueAnim = when (animModel) {
            Scale -> animAnimator?.playScale(fab)
            Alpha -> animAnimator?.playAlpha(fab)
            AnimModel.None -> null
        }

        valueAnim?.startAnimation()
    }

    fun stopAnimator(colorModel: ColorModel = Background, colorOperation: Int = Color.MAGENTA) {
        valueColor?.stopAnimation()
        valueAnim?.stopAnimation()

        colorAnimator?.stopColoring(fab, colorModel, colorOperation)
        animAnimator?.stopAnimation(fab)

        valueColor = null
        valueAnim = null

        colorAnimator = null
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

