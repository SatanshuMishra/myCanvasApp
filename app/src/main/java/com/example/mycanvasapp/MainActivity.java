package com.example.mycanvasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    RequestQueue queue;
    String url;
    String id = "100281";
    JsonObjectRequest JSONObjectRequest;
    String text;
    Boolean locked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CanvasAssignmentsAPI();
    }

    public void changeView(View view){
        Intent intent = new Intent(this, StudentView.class);
        startActivity(intent);
    }

    void CanvasAssignmentsAPI(){
        this.queue = Volley.newRequestQueue(this);
        this.url = "https://ubc.instructure.com:443/api/v1/courses?enrollment_type=student&enrollment_state=active&state[]=available";
        this.JSONObjectRequest = new JsonObjectRequest(Request.Method.GET,this.url,null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("INNER" + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Errr", Toast.LENGTH_SHORT);
            }
        }) {     
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Authorization", "Bearer 11224~3W6jNTemMtADzpLrzxhN8PpNLS8qrBChqZ27zNEX7SKFKxfjLTzUYVhvlAOYcKc1");
                return params;  
        }
    };
        queue.add(this.JSONObjectRequest);
    }
}