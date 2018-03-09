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

        val object1 = AnimatorObject(fab_1)
        val object2 = AnimatorObject(fab_2)
        val object3 = AnimatorObject(fab_3)
        val object4 = AnimatorObject(fab_4)
        val object5 = AnimatorObject(fab_5)

        btn_start.setOnClickListener {
            object1.createAnimator(colorModel = ColorModel.Icon,
                    colorRange = intArrayOf(Color.WHITE, Color.YELLOW))
            object2.createAnimator(animModel = AnimModel.Alpha)
            object3.createAnimator(animModel = AnimModel.Scale)
            object4.createAnimator(duration = 300)
            object5.createAnimator(colorRange = intArrayOf(Color.DKGRAY, Color.MAGENTA))
        }

        btn_stop.setOnClickListener {
            object1.stopAnimator(colorModel = ColorModel.Icon)
            object2.stopAnimator()
            object3.stopAnimator()
            object4.stopAnimator()
            object5.stopAnimator()
        }
    }
}
