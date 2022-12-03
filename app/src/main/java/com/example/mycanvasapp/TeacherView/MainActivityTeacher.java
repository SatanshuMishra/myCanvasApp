package com.example.mycanvasapp.TeacherView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mycanvasapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityTeacher extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    TextView pageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_teacher);

        pageName = findViewById(R.id.page_identity);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        NavigationUI.setupWithNavController(bottomNav, navController);

    }

    public void setActionBarTitle(String title){
        pageName.setText(title);
    }

}