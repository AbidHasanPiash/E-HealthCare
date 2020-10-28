package com.abidhasan.e_healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.transition.Fade;
import android.view.View;

public class Ambulance extends AppCompatActivity {
    CoordinatorLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        layout = findViewById(R.id.layout);
        SmoothFade();
    }

    private void SmoothFade() {
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        fade.excludeTarget(layout, true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);
    }
}
