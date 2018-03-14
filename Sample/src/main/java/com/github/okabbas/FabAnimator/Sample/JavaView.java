package com.github.okabbas.FabAnimator.Sample;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class JavaView extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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

        final AnimatorObject object1 = new AnimatorObject();
        final AnimatorObject object2 = new AnimatorObject();
        final AnimatorObject object3 = new AnimatorObject();
        final AnimatorObject object4 = new AnimatorObject();
        final AnimatorObject object5 = new AnimatorObject();
    }
}
