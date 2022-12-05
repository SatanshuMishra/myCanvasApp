package com.example.mycanvasapp.Settings;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.mycanvasapp.R;
import com.example.mycanvasapp.StudentView.StudentView;

public class AppearanceActivity extends Activity {

    ImageView imageView_backArrow;
    Switch switch_colorMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance);

        imageView_backArrow = findViewById(R.id.imageView_backArrow);
        switch_colorMode = findViewById(R.id.switch_colorMode);

//        if(switch_colorMode.isChecked()) {
//
//        }

        imageView_backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity();
            }
        });
    }

    public void openSettingsActivity() {
        Intent openSettings = new Intent(this, StudentView.class);
        startActivity(openSettings);

    }
}