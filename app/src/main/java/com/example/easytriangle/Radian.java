package com.example.easytriangle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Radian extends AppCompatActivity {

    EditText Degrees, Radians;
    Button submit;
    double numA, numB, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radian);

        Degrees = (EditText) findViewById(R.id.Degrees);
        Radians = (EditText) findViewById(R.id.Radians);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    numA = Double.parseDouble(String.valueOf(Degrees.getText()));
                } catch (Exception ex) {
                    numA = 0.0;
                }
                try {
                    numB = Double.parseDouble(Radians.getText().toString());
                } catch (Exception ex) {
                    numB = 0.0;
                }
                if (numA > 0 && numB > 0) {
                    //if all have been filled in, prompt user.
                    Toast.makeText(getApplicationContext(), "Too many inputs", Toast.LENGTH_SHORT).show();
                } else if (numA > 0 ) {
                    sum = Math.toRadians( numA );
                    Radians.setText(Double.toString(sum));
                } else if (numB > 0 ) {
                    sum = Math.toDegrees( numB );
                    Degrees.setText(Double.toString(sum));
                } else {
                    // this is to handle having less than 2 inputs
                    Toast.makeText(getApplicationContext(), "Not enough inputs", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}