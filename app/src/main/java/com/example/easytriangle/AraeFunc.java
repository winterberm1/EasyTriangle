package com.example.easytriangle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.easytriangle.R.*;

public class AraeFunc extends AppCompatActivity {

    EditText SideA, SideB;
    TextView answer;
    Button answer_button, clear_button;
    double numA = 0.0, numB = 0.0;
    double sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arae_func);
        SideA = (EditText) findViewById(id.SideA);
        SideB = (EditText) findViewById(id.SideB);
        answer = (TextView) findViewById(id.answer);

        answer_button = (Button) findViewById(id.answer_button);
        clear_button = (Button) findViewById(id.clearBut);

        clear_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                SideA.setText("");
                SideB.setText("");
                answer.setText("");
                numA = 0.0;
                numB = 0.0;
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

                if (numA == 0 || numB == 0 ) {
                    //if all have been filled in, prompt user.
                    Toast.makeText(getApplicationContext(), "Not enough inputs", Toast.LENGTH_SHORT).show();
                }
                else {
                    // this is to handle having less than 2 inputs
                    sum = (.5)*numA*numB;
                    answer.setText(Double.toString(sum));
                }


            }
        });

    }
}
