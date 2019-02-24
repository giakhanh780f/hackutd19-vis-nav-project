package com.hackutd19.vis_nav;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CameraActivity extends AppCompatActivity {

    public static String debugstmt = "";
    TextView result;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        this.getSupportActionBar().hide();
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
        result = findViewById(R.id.results);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            /* do what you need to do */
            if(result != null) {
                result.setText(debugstmt);
            } else {
                System.out.println("WARN: Cannot find result textbox");
            }
            /* and here comes the "trick" */
            handler.postDelayed(this, 5000);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 100);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}
