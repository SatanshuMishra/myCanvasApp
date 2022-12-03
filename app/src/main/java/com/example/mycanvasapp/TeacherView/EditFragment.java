package com.example.mycanvasapp.TeacherView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mycanvasapp.R;

public class EditFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    View view;
    Spinner spinner;
    Spinner spinner2;
    TextView text_textview;
    TextView descrip_textview;
    TextView pages_textview;
    EditText text_editText;
    EditText pages_editText;
    EditText descrip_editText;
    EditText title_editText;
    EditText deadline_editText;
    Button doneButton;
    Button cancelButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_edit_teacher, container, false);

        ((MainActivityTeacher) getActivity()).setActionBarTitle("ASSIGN\nPAGE");

        spinner = view.findViewById(R.id.type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);

        spinner2 = view.findViewById(R.id.course_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.courses, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter2);

        text_textview = view.findViewById(R.id.textView_text);
        descrip_textview = view.findViewById(R.id.textView_descrip);
        pages_textview = view.findViewById(R.id.textView_pages);
        title_editText = view.findViewById(R.id.editText_title);
        text_editText = view.findViewById(R.id.editText_Text);
        pages_editText = view.findViewById(R.id.editText_pages);
        descrip_editText = view.findViewById(R.id.editText_descrip);
        deadline_editText = view.findViewById(R.id.editTextDate);

        doneButton = view.findViewById(R.id.button);
        cancelButton = view.findViewById(R.id.button2);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        String type = getArguments().getString("Type");
        String title = getArguments().getString("Title");
        String course = getArguments().getString("Course");
        String deadline = getArguments().getString("Date");
        if(type.equals("Reading")){
            String text = getArguments().getString("Text");
            String pages = getArguments().getString("Pages");
            spinner.setSelection(0);
            text_editText.setText(text);
            pages_editText.setText(pages);
        }else{
            String descrip = getArguments().getString("Descrip");
            spinner.setSelection(1);
            descrip_editText.setText(descrip);
        }


        if(course.equals("COSC 341")){
            spinner2.setSelection(0);
        }else if(course.equals("COSC 111")){
            spinner2.setSelection(1);
        }else{
            spinner2.setSelection(2);
        }

        title_editText.setText(title);
        deadline_editText.setText(deadline);

        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("Type", spinner.getSelectedItem().toString());
                args.putString("Title", title_editText.getText().toString());
                args.putString("Course", spinner2.getSelectedItem().toString());
                args.putString("Date", deadline_editText.getText().toString());
                if(type.equals("Reading")){
                    args.putString("Text", text_editText.getText().toString());
                    args.putString("Pages", pages_editText.getText().toString());
                }else{
                    args.putString("Descrip", descrip_editText.getText().toString());
                }
                Navigation.findNavController(v).navigate(R.id.action_editFragment_to_coursesFragment, args);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_editFragment_to_coursesFragment);
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String selected_type = parent.getItemAtPosition(pos).toString();

        if(selected_type.equals("Reading")){
            text_textview.setVisibility(View.VISIBLE);
            text_editText.setVisibility(View.VISIBLE);
            pages_textview.setVisibility(View.VISIBLE);
            pages_editText.setVisibility(View.VISIBLE);
            descrip_textview.setVisibility(View.GONE);
            descrip_editText.setVisibility(View.GONE);
        }
        if(selected_type.equals("Task/Activity")){
            text_textview.setVisibility(View.GONE);
            text_editText.setVisibility(View.GONE);
            pages_textview.setVisibility(View.GONE);
            pages_editText.setVisibility(View.GONE);
            descrip_textview.setVisibility(View.VISIBLE);
            descrip_editText.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}