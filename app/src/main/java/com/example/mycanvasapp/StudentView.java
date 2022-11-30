package com.example.mycanvasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycanvasapp.databinding.ActivityStudentViewBinding;

public class StudentView extends AppCompatActivity {

    private ActivityStudentViewBinding binding;
    TextView pageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragament(new OverviewFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.overview:
                    pageName = findViewById(R.id.page_identity);
                    pageName.setSingleLine(false);
                    pageName.setText("YOUR\nOVERVIEW");
                    replaceFragament(new OverviewFragment());
                    break;
                case R.id.deadlines:
                    pageName = findViewById(R.id.page_identity);
                    pageName.setSingleLine(false);
                    pageName.setText("YOUR\nDEADLINES");
                    replaceFragament(new DeadlinesFragment());
                    break;
                case R.id.progress:
                    pageName = findViewById(R.id.page_identity);
                    pageName.setSingleLine(false);
                    pageName.setText("YOUR\nPROGRESS");
                    replaceFragament(new ProgressFragment());
                    break;
                case R.id.schedule:
                    pageName = findViewById(R.id.page_identity);
                    pageName.setSingleLine(false);
                    pageName.setText("YOUR\nSCHEDULE");
                    Toast.makeText(getApplicationContext(), "Schedule Selected", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.settings:
                    pageName = findViewById(R.id.page_identity);
                    pageName.setSingleLine(false);
                    pageName.setText("YOUR\nSETTINGS");
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