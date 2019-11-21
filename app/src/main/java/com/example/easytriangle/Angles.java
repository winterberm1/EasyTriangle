package com.example.easytriangle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.easytriangle.R.*;

public class Angles extends AppCompatActivity{

    EditText AngleA, AngleB, AngleC;
    Button answer_button, clear_button;
    double numA = 0.0, numB = 0.0, numC = 0.0;
    double sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_angle);
        AngleA=(EditText) findViewById(id.AngleA);
        AngleB=(EditText) findViewById(id.AngleB);
        AngleC = (EditText) findViewById(id.AngleC);
        answer_button=(Button) findViewById(id.answer_button);
        clear_button = (Button) findViewById(id.clearBut);

        clear_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                AngleA.setText("");
                AngleB.setText("");
                AngleC.setText("");
                numA = 0.0;
                numB = 0.0;
                numC = 0.0;
            }
        });

        answer_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {
                    numA = Double.parseDouble(String.valueOf(AngleA.getText()));
                }
                catch (Exception ex) {
                    numA = 0.0;
                }

                try {
                    numB = Double.parseDouble(AngleB.getText().toString());
                }
                catch (Exception ex) {
                    numB = 0.0;
                }

                try {
                    numC = Double.parseDouble(AngleC.getText().toString());
                }
                catch (Exception ex) {
                    numC = 0.0;
                }


                if (numA > 0 && numB > 0 && numC > 0) {
                    //if all have been filled in, prompt user.
                    Toast.makeText(getApplicationContext(), "Too many inputs", Toast.LENGTH_SHORT).show();
                }
                else if (numA + numB + numC > 180) {
                    //if the interior angles exceed 180, then the angles are incorrect and would give an impossible value.
                    Toast.makeText(getApplicationContext(), "Impossible interior angles.", Toast.LENGTH_SHORT).show();
                }
                else if (numA > 0 && numB > 0) {
                    sum = 180 - numA - numB;
                    AngleC.setText(Double.toString(sum));
                }
                else if (numA > 0 && numC > 0) {
                    sum = 180 - numA - numC;
                    AngleB.setText(Double.toString(sum));
                }
                else if (numB > 0 && numC > 0) {
                    sum = 180 - numB - numC;
                    AngleA.setText(Double.toString(sum));
                }
                else {
                    // this is to handle having less than 2 inputs
                    Toast.makeText(getApplicationContext(), "Not enough inputs", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

}
