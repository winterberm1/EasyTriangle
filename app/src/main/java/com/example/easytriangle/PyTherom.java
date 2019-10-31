package com.example.easytriangle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PyTherom extends AppCompatActivity {

    EditText SideA;
    EditText SideB;
    Switch Hypotnuse;
    Button answer_button;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_py_therom);
        SideA=(EditText) findViewById(R.id.SideA);
        SideB=(EditText) findViewById(R.id.SideB);
        Hypotnuse=(Switch) findViewById(R.id.Hypotenuse);
        answer_button=(Button) findViewById(R.id.answer_button);
        answer=(TextView) findViewById(R.id.answer);

        answer_button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    double sum;
                    Boolean hyp = Hypotnuse.isChecked();
                    double numA = Double.parseDouble(SideA.getText().toString());
                    double numB = Double.parseDouble(SideB.getText().toString());

                    if(hyp == true) {
                        sum = Math.sqrt(Math.pow(numB, 2) - Math.pow(numA, 2));
                    }else{
                        sum = Math.sqrt(Math.pow(numA, 2) + Math.pow(numB, 2));
                    }

                    answer.setText(Double.toString(sum));
            }
        });
    }
}
