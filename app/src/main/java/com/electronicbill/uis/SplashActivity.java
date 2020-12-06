package com.electronicbill.uis;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.electronicbill.R;
import com.electronicbill.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        new Handler()
                .postDelayed(()->{
                    Intent intent;
                        intent = new Intent(this, MainActivity.class);

                    startActivity(intent);
                    finish();
                },2000);

    }
}
