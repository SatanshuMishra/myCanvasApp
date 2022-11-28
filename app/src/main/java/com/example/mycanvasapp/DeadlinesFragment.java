package com.example.mycanvasapp;

import android.app.AppComponentFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class DeadlinesFragment extends Fragment {

    LinearLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deadlines, container, false);
        layout = (LinearLayout) view.findViewById(R.id.container_deadlines);
        addCard();


        return view;
    }

    private void addCard() {
        View view = getLayoutInflater().inflate(R.layout.deadline_card, null);
        layout.addView(view);
    }
}