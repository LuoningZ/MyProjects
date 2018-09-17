package com.gy.limguide.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gy.limguide.MainActivity;
import com.gy.limguide.R;

public class FlashActivity extends AppCompatActivity {

    Handler handler=new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_flash_activity);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(FlashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        },2000);
    }
}
