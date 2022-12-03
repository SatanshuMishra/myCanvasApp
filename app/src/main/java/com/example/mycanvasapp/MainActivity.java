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
import com.android.volley.toolbox.Volley;
import com.example.mycanvasapp.StudentView.StudentView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    RequestQueue queue;
    String url;
    String id = "100281";
    JsonArrayRequest JSONArrayRequest;
    String text;
    Boolean locked = true;
    JSONObject obj;

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
        this.url = "https://ubc.instructure.com:443/api/v1/courses?enrollment_type=student&enrollment_state=active&state"+ "[]" + "=available&access_token=11224~3W6jNTemMtADzpLrzxhN8PpNLS8qrBChqZ27zNEX7SKFKxfjLTzUYVhvlAOYcKc1";
        this.JSONArrayRequest = new JsonArrayRequest(Request.Method.GET,this.url,null,new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response) {
//                System.out.println("INNER" + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Errr", Toast.LENGTH_SHORT);
            }
        }){
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> params = new HashMap<>();
            params.put("User-Agent","Mozilla/5.0");
            return params;
        }
    };
        queue.add(this.JSONArrayRequest);
    }


}