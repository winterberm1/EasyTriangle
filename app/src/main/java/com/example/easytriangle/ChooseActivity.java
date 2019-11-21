package com.example.easytriangle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {

    Button pyBtn, ang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        pyBtn = (Button) findViewById(R.id.PyTherom);
        ang = (Button) findViewById(R.id.angles);

        pyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ChooseActivity.this,
                        PyTherom.class);
                startActivity(myIntent);
            }
        });

        ang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ChooseActivity.this, Angles.class);
                startActivity(myIntent);
            }
        });
    }
}
