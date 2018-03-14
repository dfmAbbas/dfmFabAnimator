package com.github.okabbas.FabAnimator.Sample;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.okabbas.FabAnimator.anim.AnimModel;
import com.github.okabbas.FabAnimator.color.ColorModel;
import com.github.okabbas.FabAnimator.handler.AnimatorObject;

public class JavaView extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_java, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final FloatingActionButton fab_1 = (FloatingActionButton) view.findViewById(R.id.fab_1);
        final FloatingActionButton fab_2 = (FloatingActionButton) view.findViewById(R.id.fab_2);
        final FloatingActionButton fab_3 = (FloatingActionButton) view.findViewById(R.id.fab_3);
        final FloatingActionButton fab_4 = (FloatingActionButton) view.findViewById(R.id.fab_4);
        final FloatingActionButton fab_5 = (FloatingActionButton) view.findViewById(R.id.fab_5);

        Button btn_start = (Button) view.findViewById(R.id.btn_start);
        Button btn_stop = (Button) view.findViewById(R.id.btn_stop);

        final AnimatorObject animatorObject1 = new AnimatorObject();
        final AnimatorObject animatorObject2 = new AnimatorObject();
        final AnimatorObject animatorObject3 = new AnimatorObject();
        final AnimatorObject animatorObject4 = new AnimatorObject();
        final AnimatorObject animatorObject5 = new AnimatorObject();

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatorObject1.create(fab_1);
                animatorObject1.setColoring(ColorModel.BG, 1500, new int[]{Color.BLACK, Color.LTGRAY, Color.MAGENTA});
                animatorObject1.setAnimation(AnimModel.SHAKE, 800);
                animatorObject1.start();

                animatorObject2.create(fab_2);
                animatorObject2.setColoring(ColorModel.BG, 400, new int[]{Color.MAGENTA, Color.RED});
                animatorObject2.start();

                animatorObject3.create(fab_3);
                animatorObject3.setAnimation(AnimModel.JUMP, 800);
                animatorObject3.start();

                animatorObject4.create(fab_4);
                animatorObject4.setColoring(ColorModel.ICON, 400, new int[]{Color.WHITE, Color.BLACK});
                animatorObject4.start();

                animatorObject5.create(fab_5);
                animatorObject5.setColoring(ColorModel.BG, 800, new int[]{Color.MAGENTA, Color.BLACK});
                animatorObject5.setAnimation(AnimModel.BLINKER, 800);
                animatorObject5.start();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatorObject1.stopColoring(ColorModel.BG, Color.MAGENTA);
                animatorObject1.stopAnimation();

                animatorObject2.stopColoring(ColorModel.BG, Color.BLACK);

                animatorObject3.stopAnimation();

                animatorObject4.stopColoring(ColorModel.ICON, Color.BLACK);

                animatorObject5.stopColoring(ColorModel.BG, Color.BLACK);
                animatorObject5.stopAnimation();
            }
        });
    }
}
