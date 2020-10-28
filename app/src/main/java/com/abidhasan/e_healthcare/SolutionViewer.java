package com.abidhasan.e_healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SolutionViewer extends AppCompatActivity {
    TextView textView;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution_viewer);
        textView= findViewById(R.id.textView);
        string = getIntent().getExtras().getString("value");
        textView.setText(string);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
