package com.github.dfmabbas.sample


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.dfmabbas.animator.anim.AnimModel
import com.github.dfmabbas.animator.color.ColorModel
import com.github.dfmabbas.animator.handler.Animator
import kotlinx.android.synthetic.main.fragment_kotlin.*

class KotlinView : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_kotlin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animator1 = Animator().playOn(fab_1)
                .setColoring(colorRange = intArrayOf(Color.BLACK, Color.LTGRAY, Color.MAGENTA), duration = 1500)
                .setAnimation(animModel = AnimModel.SHAKE)

        val animator2 = Animator().playOn(fab_2)
                .setColoring(duration = 400)

        val animator3 = Animator().playOn(fab_3)
                .setAnimation(AnimModel.JUMP, 800)

        val animator4 = Animator().playOn(fab_4)
                .setColoring(ColorModel.ICON, 400, colorRange = intArrayOf(Color.WHITE, Color.BLACK))

        val animator5 = Animator().playOn(fab_5)
                .setColoring(colorRange = intArrayOf(Color.MAGENTA, Color.BLACK))
                .setAnimation(animModel = AnimModel.BLINKER)

        btn_start.setOnClickListener {
            animator1.start()
            animator2.start()
            animator3.start()
            animator4.start()
            animator5.start()
        }

        btn_stop.setOnClickListener {
            animator1.stop();
            animator2.stop();
            animator3.stop();
            animator4.stop();
            animator5.stop();
        }
    }
}
