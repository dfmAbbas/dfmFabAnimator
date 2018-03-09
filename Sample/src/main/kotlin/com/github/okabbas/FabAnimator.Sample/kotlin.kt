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

class kotlin : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_kotlin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val animatorObject1 = AnimatorObject(fab_1)
        val animatorObject2 = AnimatorObject(fab_2)
        val animatorObject3 = AnimatorObject(fab_3)
        val animatorObject4 = AnimatorObject(fab_4)
        val animatorObject5 = AnimatorObject(fab_5)

        btn_start.setOnClickListener {
            /*
                Using the createAnimator method, you can set what you need
                The createAnimator method has default values, and if you do not enter these values,
                these values will be imported into kotlin by default and auto.
            */

            //Here we will only change the FAB icon color.
            animatorObject1.createAnimator(colorModel = ColorModel.Icon,
                    colorRange = intArrayOf(Color.WHITE, Color.YELLOW))

            //Here we change the color of the FAB background.
            animatorObject2.createAnimator(animModel = AnimModel.Alpha)
            animatorObject3.createAnimator(animModel = AnimModel.Scale)
            animatorObject4.createAnimator(duration = 300)
            animatorObject5.createAnimator(colorRange = intArrayOf(Color.DKGRAY, Color.MAGENTA))
        }

        btn_stop.setOnClickListener {

            // When the AnimatorObject is finished, we must stop using the stopAnimator method.

            /* Here the animatorObject1 is said to have stopped
              and this class has already done the job of changing the color of the icons,
              and we also set the background color of the FAB after the end of the job.
             */
            animatorObject1.stopAnimator(colorModel = ColorModel.Icon)

            //and here we use default values
            animatorObject2.stopAnimator()
            animatorObject3.stopAnimator()
            animatorObject4.stopAnimator()
            animatorObject5.stopAnimator()
        }
    }
}
