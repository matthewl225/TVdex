package com.example.tvdexapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureNextScreen();

        /*Button btn = findViewById(R.id.openCam);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });*/

    }

    private void configureNextScreen(){
        RelativeLayout rlayout = (RelativeLayout) findViewById(R.id.mainLayout); //might have to change the mainlayout
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SelectScreenActivity.class));

            }

        });


        /*new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this, SelectScreenActivity.class));
            finish();
        }, 10000);*/



    }
}