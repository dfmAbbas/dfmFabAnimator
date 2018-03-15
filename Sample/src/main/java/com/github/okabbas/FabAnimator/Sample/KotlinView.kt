package com.github.okabbas.FabAnimator.Sample


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.okabbas.FabAnimator.anim.AnimModel
import com.github.okabbas.FabAnimator.color.ColorModel
import com.github.okabbas.FabAnimator.handler.AnimatorObject
import kotlinx.android.synthetic.main.fragment_kotlin.*

class KotlinView : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_kotlin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animatorObject1 = AnimatorObject()
        val animatorObject2 = AnimatorObject()
        val animatorObject3 = AnimatorObject()
        val animatorObject4 = AnimatorObject()
        val animatorObject5 = AnimatorObject()

        btn_start.setOnClickListener {
            animatorObject1.create(fab_1)
                    .setColoring(colorRange = intArrayOf(Color.BLACK, Color.LTGRAY, Color.MAGENTA), duration = 1500)
                    .setAnimation(animModel = AnimModel.SHAKE)
                    .start()

            animatorObject2.create(fab_2)
                    .setColoring(duration = 400)
                    .start()

            animatorObject3.create(fab_3)
                    .setAnimation(AnimModel.JUMP, 800)
                    .start()

            animatorObject4.create(fab_4)
                    .setColoring(ColorModel.ICON, 400, colorRange = intArrayOf(Color.WHITE, Color.BLACK))
                    .start()

            animatorObject5.create(fab_5)
                    .setColoring(colorRange = intArrayOf(Color.MAGENTA, Color.BLACK))
                    .setAnimation(animModel = AnimModel.BLINKER)
                    .start()
        }

        btn_stop.setOnClickListener {
            animatorObject1.stopColoring()
                    .stopAnimation()

            animatorObject2.stopColoring(colorOperation = Color.BLACK)

            animatorObject3.stopAnimation()

            animatorObject4.stopColoring(colorModel = ColorModel.ICON)

            animatorObject5.stopColoring()
                    .stopAnimation()
        }
    }
}
