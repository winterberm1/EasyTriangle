package com.example.easytriangle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CosFunc extends AppCompatActivity {
    EditText adjSide, hyp, angleA;
    Button ans, clear;
    double AngA = 0.0, sideA = 0.0, hySide = 0.0;
    double sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos_func);

        adjSide = (EditText) findViewById(R.id.SideB);
        hyp = (EditText) findViewById(R.id.SideC);
        angleA = (EditText) findViewById(R.id.AngleA);
        ans = (Button) findViewById(R.id.answer_button);
        clear = (Button) findViewById(R.id.clearBut);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angleA.setText("");
                adjSide.setText("");
                hyp.setText("");
                AngA = 0.0;
                sideA = 0.0;
                hySide= 0.0;
            }
        });

        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    AngA = Double.parseDouble(String.valueOf(angleA.getText()));
                } catch (Exception ex) {
                    AngA = 0.0;
                }

                try {
                    sideA = Double.parseDouble(adjSide.getText().toString());
                } catch (Exception ex) {
                    sideA = 0.0;
                }

                try {
                    hySide = Double.parseDouble(hyp.getText().toString());
                } catch (Exception ex) {
                    hySide = 0.0;
                }

                if (AngA > 0 && sideA > 0 && hySide > 0) {
                    //if all have been filled in, prompt user.
                    Toast.makeText(getApplicationContext(), "Too many inputs", Toast.LENGTH_SHORT).show();
                } else if (AngA >= 90) {
                    //if the interior angles exceed 180, then the angles are incorrect and would give an impossible value.
                    Toast.makeText(getApplicationContext(), "Impossible angle.", Toast.LENGTH_SHORT).show();
                } else if (AngA > 0 && sideA > 0) {
                    sum = (sideA * 1.0) / Math.cos(Math.toRadians(AngA));
                    hyp.setText(Double.toString(sum));
                } else if (AngA > 0 && hySide > 0) {
                    sum = hySide * Math.cos(Math.toRadians(AngA));
                    adjSide.setText(Double.toString(sum));
                } else if (sideA > 0 && hySide > 0) {
                    sum = Math.toDegrees(Math.acos((sideA * 1.0) / hySide));
                    angleA.setText(Double.toString(sum));
                } else {
                    // this is to handle having less than 2 inputs
                    Toast.makeText(getApplicationContext(), "Not enough inputs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
