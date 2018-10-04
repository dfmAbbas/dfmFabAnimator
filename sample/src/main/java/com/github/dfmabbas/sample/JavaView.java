package com.github.dfmabbas.sample;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.dfmabbas.animator.anim.AnimModel;
import com.github.dfmabbas.animator.color.ColorModel;
import com.github.dfmabbas.animator.handler.Animator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class JavaView extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_java, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final FloatingActionButton fab_1 = view.findViewById(R.id.fab_1);
        final FloatingActionButton fab_2 = view.findViewById(R.id.fab_2);
        final FloatingActionButton fab_3 = view.findViewById(R.id.fab_3);
        final FloatingActionButton fab_4 = view.findViewById(R.id.fab_4);
        final FloatingActionButton fab_5 = view.findViewById(R.id.fab_5);

        Button btn_start = view.findViewById(R.id.btn_start);
        Button btn_stop = view.findViewById(R.id.btn_stop);

        final Animator animator1 = new Animator().playOn(fab_1)
                .setColoring(ColorModel.BG, 1500, new int[]{Color.BLACK, Color.LTGRAY, Color.MAGENTA})
                .setAnimation(AnimModel.SHAKE, 800);

        final Animator animator2 = new Animator().playOn(fab_2)
                .setColoring(ColorModel.BG, 400, new int[]{Color.MAGENTA, Color.RED});

        final Animator animator3 = new Animator().playOn(fab_3)
                .setAnimation(AnimModel.JUMP, 800);

        final Animator animator4 = new Animator().playOn(fab_4)
                .setColoring(ColorModel.ICON, 400, new int[]{Color.WHITE, Color.BLACK});

        final Animator animator5 = new Animator().playOn(fab_5)
                .setColoring(ColorModel.BG, 800, new int[]{Color.MAGENTA, Color.BLACK})
                .setAnimation(AnimModel.BLINKER, 800);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animator1.start();
                animator2.start();
                animator3.start();
                animator4.start();
                animator5.start();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animator1.stop();
                animator2.stop();
                animator3.stop();
                animator4.stop();
                animator5.stop();
            }
        });
    }
}
