package com.example.mycanvasapp;

import android.app.AppComponentFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeadlinesFragment extends Fragment {

    LinearLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deadlines, container, false);
        layout = (LinearLayout) view.findViewById(R.id.container_deadlines);
        addCard("COSC 341", "Project Step 4", "Dec 5th");
        addCard("COSC 304", "Lab 10", "Dec 7th");


        return view;
    }

    private void addCard(String course, String assignment, String time) {
        View view = getLayoutInflater().inflate(R.layout.deadline_card, null);
        TextView courseName = view.findViewById(R.id.course_name);
        courseName.setText(course);
        TextView assignmentName = view.findViewById(R.id.assignment_title);
        assignmentName.setText(assignment);
        TextView dueTime = view.findViewById(R.id.due_time);
        dueTime.setText(time);
        layout.addView(view);
    }
}