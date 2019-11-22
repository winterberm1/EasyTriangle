package com.example.easytriangle;

import java.lang.Math;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.easytriangle.R.*;

public class Sin extends AppCompatActivity{
    EditText AngleA, oppSide, Hypot;
    Button answer_button, clear_button;
    double AngA = 0.0, sideO = 0.0, hySide = 0.0;
    double sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_sin);

        AngleA=(EditText) findViewById(id.AngleA);
        oppSide =(EditText) findViewById(id.SideA);
        Hypot = (EditText) findViewById(id.SideC);
        answer_button=(Button) findViewById(id.answer_button);
        clear_button = (Button) findViewById(id.clearBut);

        clear_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                AngleA.setText("");
                oppSide.setText("");
                Hypot.setText("");
                AngA = 0.0;
                sideO = 0.0;
                hySide = 0.0;
            }
        });

        answer_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {
                    AngA = Double.parseDouble(String.valueOf(AngleA.getText()));
                }
                catch (Exception ex) {
                    AngA = 0.0;
                }

                try {
                    sideO = Double.parseDouble(oppSide.getText().toString());
                }
                catch (Exception ex) {
                    sideO = 0.0;
                }

                try {
                    hySide = Double.parseDouble(Hypot.getText().toString());
                }
                catch (Exception ex) {
                    hySide = 0.0;
                }


                if (AngA > 0 && sideO > 0 && hySide > 0) {
                    //if all have been filled in, prompt user.
                    Toast.makeText(getApplicationContext(), "Too many inputs", Toast.LENGTH_SHORT).show();
                }
                else if (AngA >= 90) {
                    //if the interior angles exceed 180, then the angles are incorrect and would give an impossible value.
                    Toast.makeText(getApplicationContext(), "Impossible angle.", Toast.LENGTH_SHORT).show();
                }
                else if (AngA > 0 && sideO > 0) {
                    sum = (sideO * 1.0) / Math.sin(Math.toRadians(AngA)) ;
                    Hypot.setText(Double.toString(sum));
                }
                else if (AngA > 0 && hySide > 0) {
                    sum = hySide * Math.sin(Math.toRadians(AngA));
                    oppSide.setText(Double.toString(sum));
                }
                else if (sideO > 0 && hySide > 0) {
                    sum = Math.toDegrees(Math.asin((sideO * 1.0) / hySide));
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
