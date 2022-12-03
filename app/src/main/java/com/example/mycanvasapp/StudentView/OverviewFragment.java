package com.example.mycanvasapp.StudentView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycanvasapp.R;


public class OverviewFragment extends Fragment {

    Button assignmentsShowMore;
    Button tasksShowMore;
    TextView pageName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        assignmentsShowMore = view.findViewById(R.id.show_more_assignments_button);
        tasksShowMore = view.findViewById(R.id.show_more_tasks_button);

        assignmentsShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageName = getActivity().findViewById(R.id.page_identity);
                pageName.setSingleLine(false);
                pageName.setText("YOUR\nDEADLINES");
                replaceFragament(new DeadlinesFragment());
            }
        });

        tasksShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageName = getActivity().findViewById(R.id.page_identity);
                pageName.setSingleLine(false);
                pageName.setText("YOUR\nSCHEDULE");
                Toast.makeText(getContext().getApplicationContext(), "Schedule Selected", Toast.LENGTH_SHORT).show();
//                replaceFragament(new SchedulesFragment());
            }
        });

        return view;
    }

    private void replaceFragament(Fragment fragment){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}