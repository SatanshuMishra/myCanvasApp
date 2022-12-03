package com.example.mycanvasapp.TeacherView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycanvasapp.R;

public class ScheduleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((com.example.mycanvasapp.TeacherView.MainActivityTeacher) getActivity()).setActionBarTitle("YOUR\nSCHEDULE");
        return inflater.inflate(R.layout.fragment_schedule_teacher, container, false);
    }
}