package com.hackutd19.vis_nav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
    }

    public void cameraLaunch(View view) {
        Intent fieldIntent = new Intent(this, CameraActivity.class);
        startActivity(fieldIntent);
    }
}
