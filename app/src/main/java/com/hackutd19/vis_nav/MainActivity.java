package com.hackutd19.vis_nav;

import android.content.Intent;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        CameraManager manager =
                (CameraManager)getSystemService(CAMERA_SERVICE);
        try {
            for (String cameraId : manager.getCameraIdList()) {
                CameraCharacteristics chars = manager.getCameraCharacteristics(cameraId);
                // Do something with the characteristics
                Integer facing = chars.get(CameraCharacteristics.LENS_FACING);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void cameraLaunch(View view) {
        Intent fieldIntent = new Intent(this, CameraActivity.class);
        startActivity(fieldIntent);
    }
}
