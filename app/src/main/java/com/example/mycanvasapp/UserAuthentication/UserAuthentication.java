package com.example.mycanvasapp.UserAuthentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mycanvasapp.StudentView.OverviewFragment;
import com.example.mycanvasapp.R;
import com.example.mycanvasapp.StudentView.StudentView;
import com.example.mycanvasapp.databinding.ActivityStudentViewBinding;
import com.example.mycanvasapp.databinding.ActivityUserAuthenticationBinding;
import com.example.mycanvasapp.TeacherView.MainActivityTeacher;

public class UserAuthentication extends AppCompatActivity {
    private ActivityUserAuthenticationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityUserAuthenticationBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_authentication);
        setContentView(binding.getRoot());
        replaceFragament(new LoginFragment());
    }
    public void changeView(View view){
        Intent intent = new Intent(this, StudentView.class);
        startActivity(intent);
    }
    private void replaceFragament(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.user_frame_layout, fragment);
        fragmentTransaction.commit();
    }
}