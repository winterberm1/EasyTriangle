package com.example.easytriangle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.easytriangle.R.*;

public class PyTherom extends AppCompatActivity {

    EditText SideA, SideB, SideC;
    Button answer_button, clear_button;
    double numA = 0.0, numB = 0.0, numC = 0.0;
    double sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_py_therom);
        SideA=(EditText) findViewById(id.SideA);
        SideB=(EditText) findViewById(id.SideB);
        SideC = (EditText) findViewById(id.SideC);
        answer_button=(Button) findViewById(id.answer_button);
        clear_button = (Button) findViewById(id.clearBut);

        clear_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                SideA.setText("");
                SideB.setText("");
                SideC.setText("");
                numA = 0.0;
                numB = 0.0;
                numC = 0.0;
            }
        });

        answer_button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    try {
                        numA = Double.parseDouble(String.valueOf(SideA.getText()));
                    }
                    catch (Exception ex) {
                        numA = 0.0;
                    }
                    try {
                        numB = Double.parseDouble(SideB.getText().toString());
                    }
                    catch (Exception ex) {
                        numB = 0.0;
                    }
                    try {
                        numC = Double.parseDouble(SideC.getText().toString());
                    }
                    catch (Exception ex) {
                        numC = 0.0;
                    }


                    if (numA > 0 && numB > 0 && numC > 0) {
                        //if all have been filled in, prompt user.
                        Toast.makeText(getApplicationContext(), "Too many inputs", Toast.LENGTH_SHORT).show();
                    }
                    if (numA > 0 && numB > 0) {
                        sum = Math.sqrt(Math.pow(numB, 2) + Math.pow(numA, 2));
                        SideC.setText(Double.toString(sum));
                    }
                    else if (numA > 0 && numC > 0) {
                        sum = Math.sqrt(Math.pow(numC, 2) - Math.pow(numA, 2));
                        SideB.setText(Double.toString(sum));
                    }
                    else if (numB > 0 && numC > 0) {
                        sum = Math.sqrt(Math.pow(numC, 2) - Math.pow(numB, 2));
                        SideA.setText(Double.toString(sum));
                    }
                    else {
                        // this is to handle having less than 2 inputs
                        Toast.makeText(getApplicationContext(), "Not enough inputs", Toast.LENGTH_SHORT).show();
                    }


            }
        });
    }
}
