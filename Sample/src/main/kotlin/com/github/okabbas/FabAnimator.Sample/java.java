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


public class java extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_java, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton fab_1 = (FloatingActionButton) view.findViewById(R.id.fab_1);
        FloatingActionButton fab_2 = (FloatingActionButton) view.findViewById(R.id.fab_2);
        FloatingActionButton fab_3 = (FloatingActionButton) view.findViewById(R.id.fab_3);
        FloatingActionButton fab_4 = (FloatingActionButton) view.findViewById(R.id.fab_4);
        FloatingActionButton fab_5 = (FloatingActionButton) view.findViewById(R.id.fab_5);

        Button btn_start = (Button) view.findViewById(R.id.btn_start);
        Button btn_stop = (Button) view.findViewById(R.id.btn_stop);

        final AnimatorObject object1 = new AnimatorObject(fab_1);
        final AnimatorObject object2 = new AnimatorObject(fab_2);
        final AnimatorObject object3 = new AnimatorObject(fab_3);
        final AnimatorObject object4 = new AnimatorObject(fab_4);
        final AnimatorObject object5 = new AnimatorObject(fab_5);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object1.createAnimator(ColorModel.Icon, AnimModel.None, 800,
                        new int[]{Color.MAGENTA, Color.YELLOW});

                object2.createAnimator(ColorModel.Background, AnimModel.Alpha, 800,
                        new int[]{Color.MAGENTA, Color.RED});

                object3.createAnimator(ColorModel.Background, AnimModel.Scale, 800,
                        new int[]{Color.MAGENTA, Color.RED});

                object4.createAnimator(ColorModel.Background, AnimModel.None, 300,
                        new int[]{Color.MAGENTA, Color.RED});

                object5.createAnimator(ColorModel.Background, AnimModel.None, 800,
                        new int[]{Color.DKGRAY, Color.MAGENTA});
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object1.stopAnimator(ColorModel.Icon, Color.BLACK);
                object2.stopAnimator(ColorModel.Background, Color.BLACK);
                object3.stopAnimator(ColorModel.Background, Color.BLACK);
                object4.stopAnimator(ColorModel.Background, Color.BLACK);
                object5.stopAnimator(ColorModel.Background, Color.BLACK);
            }
        });
    }
}
