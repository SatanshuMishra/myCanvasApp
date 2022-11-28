package com.example.mycanvasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mycanvasapp.databinding.ActivityStudentViewBinding;

public class StudentView extends AppCompatActivity {

    private ActivityStudentViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragament(new OverviewFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.overview:
                    replaceFragament(new OverviewFragment());
                    break;
                case R.id.deadlines:
                    replaceFragament(new DeadlinesFragment());
                    break;
                case R.id.progress:
                    replaceFragament(new ProgressFragment());
                    break;
                case R.id.schedule:
                    Toast.makeText(getApplicationContext(), "Schedule Selected", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.settings:
                    Toast.makeText(getApplicationContext(), "Settings Selected", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });
    }

    private void replaceFragament(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}