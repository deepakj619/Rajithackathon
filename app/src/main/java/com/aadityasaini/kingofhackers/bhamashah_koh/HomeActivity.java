package com.aadityasaini.kingofhackers.bhamashah_koh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    private EditText aadhar;
    private Button logout;
    private CheckBox c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        aadhar=(EditText)findViewById(R.id.etAadhar);
        String s=getIntent().getStringExtra("aadhar");
        aadhar.setText(s);
        logout=(Button)findViewById(R.id.button2);
        c1=(CheckBox)findViewById(R.id.startup);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
