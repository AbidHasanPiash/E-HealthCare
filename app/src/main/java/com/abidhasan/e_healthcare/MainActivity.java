package com.abidhasan.e_healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LinearLayout firstAidLayout,healthTips,ambulance,doctor ,linearLayout;
    LottieAnimationView LottieAnimationView;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SmoothFade();

        firstAidLayout = findViewById(R.id.firstAidLayout);
        healthTips = findViewById(R.id.healthTips);
        ambulance = findViewById(R.id.ambulance);
        doctor = findViewById(R.id.doctor);
        linearLayout = findViewById(R.id.linearLayout);
        LottieAnimationView = findViewById(R.id.animation_view);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        LottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        StartAnimation();
    }

    private void StartAnimation() {
        firstAidLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView = findViewById(R.id.imageView);
                textView = findViewById(R.id.textView);
                Intent intent = new Intent(MainActivity.this, FirstAid.class);
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(firstAidLayout, "layout_transition");
                pairs[1] = new Pair<View, String>(imageView, "image_transition");
                pairs[2] = new Pair<View, String>(textView, "text_transition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });

        healthTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HealthTips.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, healthTips, ViewCompat.getTransitionName(healthTips));
                startActivity(intent, options.toBundle());
            }
        });

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ambulance.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, ambulance, ViewCompat.getTransitionName(ambulance));
                startActivity(intent, options.toBundle());
            }
        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Doctor.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, doctor, ViewCompat.getTransitionName(doctor));
                startActivity(intent, options.toBundle());
            }
        });
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

}
