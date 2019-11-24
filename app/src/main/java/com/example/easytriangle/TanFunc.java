package com.example.easytriangle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TanFunc extends AppCompatActivity {
    EditText oppSide, adjSide, angleA;
    Button ans, clear;
    double AngA = 0.0, sideO = 0.0, sideA = 0.0;
    double sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tan_func);

        oppSide = (EditText) findViewById(R.id.SideA);
        adjSide = (EditText) findViewById(R.id.SideB);
        angleA = (EditText) findViewById(R.id.AngleA);
        ans = (Button) findViewById(R.id.answer_button);
        clear = (Button) findViewById(R.id.clearBut);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oppSide.setText("");
                adjSide.setText("");
                angleA.setText("");
                AngA = 0.0;
                sideO = 0.0;
                sideA = 0.0;
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
                    sideO = Double.parseDouble(oppSide.getText().toString());
                } catch (Exception ex) {
                    sideO = 0.0;
                }

                if (AngA > 0 && sideA > 0 && sideO > 0) {
                    //if all have been filled in, prompt user.
                    Toast.makeText(getApplicationContext(), "Too many inputs", Toast.LENGTH_SHORT).show();
                } else if (AngA >= 90) {
                    //if the interior angles exceed 180, then the angles are incorrect and would give an impossible value.
                    Toast.makeText(getApplicationContext(), "Impossible angle.", Toast.LENGTH_SHORT).show();
                } else if (AngA > 0 && sideA > 0) {
                    sum = (sideA * 1.0) / Math.tan(Math.toRadians(AngA));
                    oppSide.setText(Double.toString(sum));
                } else if (AngA > 0 && sideO > 0) {
                    sum = sideO * Math.tan(Math.toRadians(AngA));
                    adjSide.setText(Double.toString(sum));
                } else if (sideA > 0 && sideO > 0) {
                    sum = Math.toDegrees(Math.atan((sideO * 1.0) / sideA));
                    angleA.setText(Double.toString(sum));
                } else {
                    // this is to handle having less than 2 inputs
                    Toast.makeText(getApplicationContext(), "Not enough inputs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
