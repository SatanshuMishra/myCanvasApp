package com.example.mycanvasapp.StudentView;

import android.app.AppComponentFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mycanvasapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DeadlinesFragment extends Fragment {

    LinearLayout layout;
    JSONObject obj;
    RequestQueue queue;
    String url;
    JsonArrayRequest JSONArrayRequest;
    String courseId;
    Boolean locked = true;
    JSONArray data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deadlines, container, false);
        layout = (LinearLayout) view.findViewById(R.id.container_deadlines);

        url = "https://ubc.instructure.com:443/api/v1/courses/"+ 100278 +"/assignments?include[]=overrides&override_assignment_dates=true&order_by=due_at&access_token=11224~bCoaZYTJAxDyRdpfu9faYnJy3Q7rDtgD19W6ktTLiRHYc4txssJ32GlCVTiiTl0S";

        fetchCourses(url);
        System.out.println("Data: " + data);
        return view;
    }

    void fetchCourses(String url){
        this.queue = Volley.newRequestQueue(getContext());
        this.url = url;
        this.JSONArrayRequest = new JsonArrayRequest(Request.Method.GET,this.url,null,new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("COURSES: " + response.toString());
                data = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), "ERROR AT fetchData DEADLINESFRAGMENT", Toast.LENGTH_SHORT);
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

    private void addCard(String course, String assignment, String time) {
        View view = getLayoutInflater().inflate(R.layout.deadline_card, null);
        TextView courseName = view.findViewById(R.id.course_name);
        courseName.setText(course);
        TextView assignmentName = view.findViewById(R.id.assignment_title);
        assignmentName.setText(assignment);
        TextView dueTime = view.findViewById(R.id.due_time);
        if(time.equals("null")){
            dueTime.setText("UNDATED");
        } else{
            Date dateA;
            try {
                dateA = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(String.valueOf(time));
                dueTime.setText(new SimpleDateFormat("EEEEEEEEE, dd MMM yyyy hh:mm:ss aa").format(dateA).toString());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        layout.addView(view);
    }





}