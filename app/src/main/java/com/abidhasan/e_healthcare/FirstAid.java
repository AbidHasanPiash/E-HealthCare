package com.abidhasan.e_healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class FirstAid extends AppCompatActivity {
    LinearLayout linearLayout;
    RelativeLayout titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);

        SmoothFade();
        titleBar = findViewById(R.id.titleBar);
        linearLayout = findViewById(R.id.linearContent);
        linearLayout.setVisibility(View.INVISIBLE);
        smoothVisible(linearLayout);
    }

    private void SmoothFade() {
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);
    }

    @Override
    public void onBackPressed() {
        smoothInvisible(linearLayout);
        smoothInvisible(titleBar);
        super.onBackPressed();
    }

    void smoothVisible(final View content){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                content.setVisibility(View.VISIBLE);
            }
        }, 450);
    }

    void smoothInvisible(final View content){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                content.setVisibility(View.INVISIBLE);
            }
        }, 100);
    }
}
