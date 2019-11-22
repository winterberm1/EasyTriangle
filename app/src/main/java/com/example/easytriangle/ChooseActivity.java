package com.example.easytriangle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {

    Button pyBtn, ang, sine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        pyBtn = (Button) findViewById(R.id.PyTherom);
        ang = (Button) findViewById(R.id.angles);
        sine = (Button) findViewById(R.id.sin);


        pyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ChooseActivity.this,
                        PyTherom.class);
                startActivity(myIntent);
            }
        });

        ang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ChooseActivity.this,
                        Angles.class);
                startActivity(myIntent);
            }
        });

        sine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ChooseActivity.this,
                        Sin.class);
                startActivity(myIntent);
            }
        });
    }
}
