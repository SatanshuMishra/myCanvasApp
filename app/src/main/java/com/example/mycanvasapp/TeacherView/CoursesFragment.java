package com.example.mycanvasapp.TeacherView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mycanvasapp.R;
import com.example.mycanvasapp.TeacherView.MainActivityTeacher;

public class CoursesFragment extends Fragment{

    View view;
    LinearLayout layout1a;
    LinearLayout layout2a;
    LinearLayout layout1b;
    LinearLayout layout2b;
    LinearLayout layout1c;
    LinearLayout layout2c;
    LinearLayout mainLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_courses_teacher, container, false);

        ((MainActivityTeacher) getActivity()).setActionBarTitle("YOUR\nCOURSES");

        layout1a = view.findViewById(R.id.reading_layout);
        layout2a = view.findViewById(R.id.tasks_act_layout);
        layout1b = view.findViewById(R.id.reading_layout2);
        layout2b = view.findViewById(R.id.task_act_layout2);
        layout1c = view.findViewById(R.id.reading_layout3);
        layout2c = view.findViewById(R.id.task_act_layout3);

        if(getArguments() != null) {
            String type = getArguments().getString("Type");
            String title = getArguments().getString("Title");
            String text = getArguments().getString("Text");
            String pages = getArguments().getString("Pages");
            String descrip = getArguments().getString("Descrip");
            String date = getArguments().getString("Date");
            String course = getArguments().getString("Course");
            if (course.equals("COSC 341")) {
                if (type.equals("Reading")) {
                    addCard1(type, title, text, pages, course, date, layout1a);
                } else {
                    addCard2(type, title, descrip, course, date, layout2a);
                }
            } else if (course.equals("COSC 111")) {
                if (type.equals("Reading")) {
                    addCard1(type, title, text, pages, course, date, layout1b);
                } else {
                    addCard2(type, title, descrip, course, date, layout2b);
                }
            } else {
                if (type.equals("Reading")) {
                    addCard1(type, title, text, pages, course, date, layout1c);
                } else {
                    addCard2(type, title, descrip, course, date, layout2c);
                }
            }
        }

        return view;
    }


    private void addCard1(String type, String s, String t, String p, String c, String d, LinearLayout layout) {
        View view = getLayoutInflater().inflate(R.layout.card_teacher, null);

        TextView titleView = view.findViewById(R.id.card_title);
        TextView textView = view.findViewById(R.id.card_text);
        TextView pagesView = view.findViewById(R.id.card_pages);
        TextView dateView = view.findViewById(R.id.card_deadline);
        TextView descripView = view.findViewById(R.id.card_descrip);

        Button delete = view.findViewById(R.id.deleteButton);
        Button edit= view.findViewById(R.id.editButton);

        titleView.setText(s);
        textView.setText(t);
        pagesView.setText(p);
        dateView.setText(d);

        textView.setVisibility(View.VISIBLE);
        pagesView.setVisibility(View.VISIBLE);
        descripView.setVisibility(View.GONE);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeView(view);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("Type", type);
                args.putString("Title", s);
                args.putString("Text", t);
                args.putString("Pages", p);
                args.putString("Course", c);
                args.putString("Date", d);
                Navigation.findNavController(v).navigate(R.id.action_coursesFragment_to_editFragment, args);
            }
        });
        layout.addView(view);
    }

    private void addCard2(String type, String s, String des, String c, String d, LinearLayout layout) {
        final View view = getLayoutInflater().inflate(R.layout.card_teacher, null);

        TextView titleView  = view.findViewById(R.id.card_title);
        TextView descripView = view.findViewById(R.id.card_descrip);
        TextView dateView = view.findViewById(R.id.card_deadline);
        TextView textView = view.findViewById(R.id.card_text);
        TextView pagesView = view.findViewById(R.id.card_pages);

        Button delete = view.findViewById(R.id.deleteButton);
        Button edit= view.findViewById(R.id.editButton);

        titleView .setText(s);
        descripView.setText(des);
        dateView.setText(d);

        textView.setVisibility(View.GONE);
        pagesView.setVisibility(View.GONE);
        descripView.setVisibility(View.VISIBLE);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeView(view);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("Type", type);
                args.putString("Title", s);
                args.putString("Descrip", des);
                args.putString("Course", c);
                args.putString("Date", d);
                Navigation.findNavController(v).navigate(R.id.action_coursesFragment_to_editFragment, args);
            }
        });

        layout.addView(view);
    }


}


