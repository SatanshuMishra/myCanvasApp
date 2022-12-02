package com.example.mycanvasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mycanvasapp.databinding.ActivityStudentViewBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class StudentView extends AppCompatActivity {

    RequestQueue queue;
    String url;
    String id = "100281";
    JsonObjectRequest JSONObjectRequest;
    String text;
    Boolean locked = true;
    JSONObject data;
    private ActivityStudentViewBinding binding;
    TextView pageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FetchData();

        replaceFragament(new OverviewFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.overview:
                    pageName = findViewById(R.id.page_identity);
                    pageName.setSingleLine(false);
                    pageName.setText("YOUR\nOVERVIEW");
                    replaceFragament(new OverviewFragment());
                    break;
                case R.id.deadlines:
                    pageName = findViewById(R.id.page_identity);
                    pageName.setSingleLine(false);
                    pageName.setText("YOUR\nDEADLINES");
                    replaceFragament(new DeadlinesFragment());
                    break;
                case R.id.progress:
                    pageName = findViewById(R.id.page_identity);
                    pageName.setSingleLine(false);
                    pageName.setText("YOUR\nPROGRESS");
                    replaceFragament(new ProgressFragment());
                    break;
                case R.id.schedule:
                    pageName = findViewById(R.id.page_identity);
                    pageName.setSingleLine(false);
                    pageName.setText("YOUR\nSCHEDULE");
                    Toast.makeText(getApplicationContext(), "Schedule Selected", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.settings:
                    pageName = findViewById(R.id.page_identity);
                    pageName.setSingleLine(false);
                    pageName.setText("YOUR\nSETTINGS");
                    Toast.makeText(getApplicationContext(), "Settings Selected", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });
    }

//    @Override
//    protected void onResume()
//    {
//        super.onResume();
//        getName();
//    }

    private void replaceFragament(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    void FetchData(){
        this.queue = Volley.newRequestQueue(this);
        this.url = "https://canvas.instructure.com/api/v1/users/self/profile?access_token=11224~GdddS9ac9XWbgPRVzgoVYsFAlIskfOSntSMgOgGSyJeagI7Rnf9uq4PluJo8Czil";
        this.JSONObjectRequest = new JsonObjectRequest(Request.Method.GET,this.url,null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                TextView headerName = findViewById(R.id.custom_header_name);
                try {
                    headerName.setHorizontallyScrolling(false);
                    String name = "HELLO\n" + response.getString("name").split(" ")[0].toUpperCase();
                    headerName.setText(name);
                } catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Errr", Toast.LENGTH_SHORT);
            }
        });
        queue.add(this.JSONObjectRequest);
    }

    public void getName(){
        try{
            System.out.println("QUERY: " + data.getString("name"));
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

}