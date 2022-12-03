package com.example.mycanvasapp.TeacherView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycanvasapp.R;

public class SettingsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((com.example.mycanvasapp.TeacherView.MainActivityTeacher) getActivity()).setActionBarTitle("YOUR\nSETTINGS");
        return inflater.inflate(R.layout.fragment_settings_teacher, container, false);
    }
}