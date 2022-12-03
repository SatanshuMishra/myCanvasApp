package com.example.mycanvasapp.TeacherView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mycanvasapp.TeacherView.MainActivityTeacher;
import com.example.mycanvasapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AssignFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    FloatingActionButton addButton;
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
    TextView pageName;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_assign_teacher, container, false);

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

        addButton = view.findViewById(R.id.addButton);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("Type", spinner.getSelectedItem().toString());
                args.putString("Title", title_editText.getText().toString());
                args.putString("Text", text_editText.getText().toString());
                args.putString("Pages", pages_editText.getText().toString());
                args.putString("Descrip", descrip_editText.getText().toString());
                args.putString("Course", spinner2.getSelectedItem().toString());
                args.putString("Date", deadline_editText.getText().toString());
                Navigation.findNavController(v).navigate(R.id.action_assignFragment_to_coursesFragment, args);
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

    public boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public void clearAll(){
        spinner.setSelected(false);
        spinner2.setSelected(false);
        descrip_editText.setText("");
        title_editText.setText("");
        pages_editText.setText("");
        text_editText.setText("");
        deadline_editText.setText("");
    }

}
