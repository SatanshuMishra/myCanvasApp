package com.example.mycanvasapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProgressFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    Button addGoalButton;
    Button selectDate;
    Button submit;
    Dialog addGoalDialog;
    EditText goalEditText;
    LinearLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        addGoalButton = view.findViewById(R.id.add_goal_button);
        addGoalDialog = new Dialog(getContext());
        addGoalDialog.setContentView(R.layout.add_goals_window);
        addGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addGoalDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//                Window window = addGoalDialog.getWindow();
//                window.getAttributes().windowAnimations = R.style.DialogAnimation;
                addGoalDialog.setCancelable(true);
                addGoalDialog.show();
            }
        });

        selectDate = addGoalDialog.findViewById(R.id.select_date_btn);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getChildFragmentManager(), "date picker");
            }
        });

        goalEditText = addGoalDialog.findViewById(R.id.goal_field);
        goalEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goalEditText.setText("");
            }
        });

        layout = view.findViewById(R.id.goals_container);
        submit = addGoalDialog.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGoalCard(goalEditText.getText().toString(), selectDate.getText().toString());
                addGoalDialog.dismiss();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        System.out.println("ENTER FUNCT");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance().format(c.getTime());
        System.out.println("DATE SELECTED: " + currentDate);
        selectDate.setText(currentDate);
    }

    public void addGoalCard(String goal, String time) {
        View view = getLayoutInflater().inflate(R.layout.goals_card, null);
        TextView goalText = view.findViewById(R.id.goal_title);
        goalText.setText(goal);
        TextView dueTime = view.findViewById(R.id.due_time);
        dueTime.setText(time);
        layout.addView(view);
    }

}