package com.example.mycanvasapp;
//
//import android.widget.Toast;
//
//import java.sql.Array;
//import com.android.volley.*;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.toolbox.JsonArrayRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//
public class CanvasAPI {

    CanvasAPI(){

    }

//
//  RequestQueue queue;
//  String url;
//  String id = "100281";
//  JsonArrayRequest JSONArrayRequest;
//  Array text;
//
//
//  void CanvasAssignmentsAPI(){
//    this.queue = Volley.newRequestQueue(this);
//    this.url = "https://ubc.instructure.com:443/api/v1/courses/" + id + "/assignments?include[]=overrides&override_assignment_dates=true&order_by=due_at";
//    this.JSONArrayRequest = new JsonArrayRequest(Request.Method.GET,this.url,new Response.Listener<Array>(){
//        @Override
//        public void onResponse(Array response) {
//            text = response;
//        }
//    }, new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError error) {
//            Toast.makeText();
//        }
//    });
//    queue.add(this.JSONArrayRequest);
//  }
//
//    public void test(){
//      Toast.makeText(getApplicationContext(), text.toString(), Toast.LENGTH_SHORT).show();
//    }
//
}