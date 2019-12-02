package com.example.easytriangle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {

    Button pyBtn, ang, sine, cos, tan, radian, area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        pyBtn = (Button) findViewById(R.id.PyTherom);
        ang = (Button) findViewById(R.id.angles);
        sine = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        radian = (Button) findViewById(R.id.radian);
        area = (Button) findViewById(R.id.area);


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
        cos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ChooseActivity.this,
                        CosFunc.class);
                startActivity(myIntent);
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ChooseActivity.this,
                        TanFunc.class);
                startActivity(myIntent);
            }
        });
        radian.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ChooseActivity.this,
                        Radian.class);
                startActivity(myIntent);
            }
        });
        area.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ChooseActivity.this,
                        AraeFunc.class);
                startActivity(myIntent);
            }
        });
    }
}
