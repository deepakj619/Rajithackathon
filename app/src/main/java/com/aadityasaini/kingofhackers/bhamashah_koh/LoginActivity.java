package com.aadityasaini.kingofhackers.bhamashah_koh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

//https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/hofAndMember/ForApp/WDYYYGG?client_id=ad7288a4-7764-436d-a727-783a977f1fe1
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private String client_id = "ad7288a4-7764-436d-a727-783a977f1fe1";
    private EditText et1;
    private Button b1;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = (Button) findViewById(R.id.button);
        et1 = (EditText) findViewById(R.id.editText2);
        tv=(TextView)findViewById(R.id.textView2);
        tv.setOnClickListener(this);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view==tv){

            Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(i);
        }
        else if(view==b1){

            String url = "https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/hofAndMember/ForApp/" + et1.getText().toString() + "?client_id="+client_id;
            JsonObjectRequest jsonRequest = new JsonObjectRequest


                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            // the response is already constructed as a JSONObject!
                            try {
                                response = response.getJSONObject("hof_Details");
                                String aadhar = response.getString("AADHAR_ID");
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                intent.putExtra("aadhar", aadhar);
                                startActivity(intent);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    });

            Volley.newRequestQueue(LoginActivity.this).add(jsonRequest);
        }
    }
}