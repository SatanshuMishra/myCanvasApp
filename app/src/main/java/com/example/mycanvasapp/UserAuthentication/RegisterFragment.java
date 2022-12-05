package com.example.mycanvasapp.UserAuthentication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.mycanvasapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class RegisterFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    View view;
    Spinner spinner;
    Button buttonRegister;
    EditText inputEmail;
    EditText inputPassword;
    EditText inputToken;
    Integer count = 0;
    private DatabaseReference mDatabase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);

        spinner = view.findViewById(R.id.spinner);
        buttonRegister = view.findViewById(R.id.buttonRegister);
        inputEmail = view.findViewById(R.id.inputEmail);
        inputPassword = view.findViewById(R.id.inputPassword);
        inputToken = view.findViewById(R.id.inputToken);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.userstatus, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase.child("users").child(count.toString()).child("Email").setValue(inputEmail.getText().toString());
                mDatabase.child("users").child(count.toString()).child("Password").setValue(inputPassword.getText().toString());
                mDatabase.child("users").child(count.toString()).child("Token").setValue(inputToken.getText().toString());
                count++;
            }
        });
            }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String selected_type = parent.getItemAtPosition(pos).toString();
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}