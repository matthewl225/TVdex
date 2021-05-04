package com.example.tvdexapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CharacterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_screen);

        FloatingActionButton closeBtn = findViewById(R.id.closeScreen);

        TextView charName = findViewById(R.id.characterName);
        Button status = findViewById(R.id.statusDisplay);
        Button birthdate = findViewById(R.id.house_display);
        Button titleDisplay = findViewById(R.id.house_display2);
        Button actorName = findViewById(R.id.actorName);

        Bundle bundle = getIntent().getExtras();
        String newQuery = bundle.getString("query");
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        Log.d("Character activity url", newQuery);

        JsonObjectRequest objectRequest = new JsonObjectRequest (Request.Method.GET, newQuery, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //textView.setText("Response: " + response.toString());
                Log.d("Rest response", response.toString());
                ArrayList<String> mylist = new ArrayList<String>();

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

                    if(!TextUtils.isEmpty(name)){
                        charName.setText(name);
                    }
                    else {
                        charName.setText("N/A");
                    }

                    if(!TextUtils.isEmpty(culture)){
                        status.setText(culture);
                    }
                    else {
                        status.setText("N/A");
                    }

                    if(!TextUtils.isEmpty(born)){
                        birthdate.setText(born);
                    }
                    else {
                        birthdate.setText("N/A");
                    }

                    if(!TextUtils.isEmpty(title.getString(0))){
                        titleDisplay.setText(title.getString(0));
                    }
                    else {
                        titleDisplay.setText("N/A");
                    }
                    if(!TextUtils.isEmpty(playedBy.getString(0))){
                        actorName.setText(playedBy.getString(0));
                    }
                    else {
                        actorName.setText("N/A");
                    }

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

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CharacterScreen.this, SelectScreenActivity.class));
            }
        });
    }
}