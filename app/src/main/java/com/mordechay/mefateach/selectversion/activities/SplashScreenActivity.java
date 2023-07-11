package com.mordechay.mefateach.selectversion.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mordechay.mefateach.selectversion.R;
import com.mordechay.mefateach.selectversion.data.Constants;
import com.mordechay.mefateach.selectversion.data.DataTransfer;
import com.mordechay.mefateach.selectversion.data.DeviceEnum;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView imageView = findViewById(R.id.imageViewSplashScreenAppIcon);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_screen_anim);
        imageView.startAnimation(animation);

        new Thread(() -> {
            performTimeConsumingTask();
            runOnUiThread(this::startNextActivity);
        }).start();
    }

    private void performTimeConsumingTask() {
        DataTransfer.device = DeviceEnum.valueOf(Build.BRAND.toUpperCase() + "_" + Build.MODEL.toUpperCase().replace(" ", "_"));
        Log.d(getClass().getName(), "device: " + DataTransfer.device.toString());
        try {
            Thread.sleep(Constants.SPLASH_SCREEN_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startNextActivity() {
        Intent intent = new Intent(SplashScreenActivity.this, SelectVersion.class);
        startActivity(intent);
        finish();
    }
}