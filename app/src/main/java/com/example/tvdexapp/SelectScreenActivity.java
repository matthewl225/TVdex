package com.example.tvdexapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SelectScreenActivity extends AppCompatActivity {
    //private TextView mTextViewResult;
    //private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_screen);

        Log.d("im here", "second activity");

        /* start here */

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://www.anapioficeandfire.com/api/characters/583";

        /*end here */

        Button btn = findViewById(R.id.openCam);

        btn.setOnClickListener(new View.OnClickListener() { // triggers camera to open
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        Button testInfoBtn = findViewById(R.id.testInfo);

        testInfoBtn.setOnClickListener(new View.OnClickListener() { // triger to test character info screen
            @Override
            public void onClick(View v) {

                /*JsonObjectRequest objectRequest = new JsonObjectRequest (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //textView.setText("Response: " + response.toString());
                        Log.d("Rest response", response.toString());

                        try {
                            //JSONObject jsonObject = response.getJSONObject("name");

                            String name = response.getString("name");
                            String culture = response.getString("culture");
                            String born = response.getString("born");
                            JSONArray title = response.getJSONArray("titles");
                            JSONArray playedBy = response.getJSONArray("playedBy");

                            Log.d("name:", name);
                            Log.d("culture:", culture);
                            Log.d("birth:", born);
                            Log.d("title:", title.getString(0));
                            Log.d("actor:", playedBy.getString(0));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

                requestQueue.add(objectRequest);*/

                Intent intent = new Intent(SelectScreenActivity.this, CharacterScreen.class);
                intent.putExtra("query", url);
                startActivity(intent);

                //startActivity(new Intent(SelectScreenActivity.this, CharacterScreen.class));
            }
        });

        //Button apiTest = findViewById(R.id.apiTest);

        /*apiTest.setOnClickListener(new View.OnClickListener() { // trigger the api
            @Override
            public void onClick(View v) {
                JsonObjectRequest objectRequest = new JsonObjectRequest (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //textView.setText("Response: " + response.toString());
                        Log.d("Rest response", response.toString());

                        try {
                            //JSONObject jsonObject = response.getJSONObject("name");

                            String name = response.getString("name");
                            String culture = response.getString("culture");
                            String born = response.getString("born");
                            JSONArray title = response.getJSONArray("titles");
                            JSONArray playedBy = response.getJSONArray("playedBy");

                            Log.d("name:", name);
                            Log.d("culture:", culture);
                            Log.d("birth:", born);
                            Log.d("title:", title.getString(0));
                            Log.d("actor:", playedBy.getString(0));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

                requestQueue.add(objectRequest);


            }
        });*/








    }
}