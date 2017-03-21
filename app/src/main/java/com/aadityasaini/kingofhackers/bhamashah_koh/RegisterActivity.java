package com.aadityasaini.kingofhackers.bhamashah_koh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private EditText aadhar;
    private EditText bankno;
    private EditText phone;
    private Button nextbutton;
    private DatabaseReference databaseReference;
    private Firebase mRef;
    private Firebase mRef2;
    private List<String> districts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        spinner = (Spinner) findViewById(R.id.spinner);
        aadhar = (EditText) findViewById(R.id.aadhar);
        bankno = (EditText) findViewById(R.id.bankno);
        phone = (EditText) findViewById(R.id.phone);
        nextbutton = (Button) findViewById(R.id.nextbutton);
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://bhamashah-bf88c.firebaseio.com/Users");
        mRef2=new Firebase("https://bhamashah-bf88c.firebaseio.com/credits");
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Ajmer");
        categories.add("Alwar");
        categories.add("Bundi");
        categories.add("Jaipur");
        categories.add("Bikaner");
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Firebase childRef=mRef.child(aadhar.getText().toString());
                Firebase mRefChild2 = childRef.child("Bank Number:");
                mRefChild2.setValue(bankno.getText().toString());
                Firebase mRefChild3 = childRef.child("Phone Number:");
                mRefChild3.setValue(phone.getText().toString());
                Intent intent = new Intent(RegisterActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });

    }
            @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        if(item.equals("Ajmer")){

                mRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot child: dataSnapshot.getChildren()) {
                            int credit=Integer.parseInt(child.getValue().toString());
                            credit=credit-1;
                            credit=credit+1;
                            Firebase mRefChild = mRef2.child("Ajmer");
                            mRefChild.setValue(credit);
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                        Log.e("MainActivity", "onCancelled", firebaseError.toException());
                    }
                });
            }
        else if(item.equals("Alwar")){

            mRef2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot child: dataSnapshot.getChildren()) {
                        int credit=Integer.parseInt(child.getValue().toString());
                        credit=credit+1;
                        Firebase mRefChild = mRef2.child("Alwar");
                        mRefChild.setValue(credit);
                    }
                }
                @Override
                public void onCancelled(FirebaseError firebaseError) {

                    Log.e("MainActivity", "onCancelled", firebaseError.toException());
                }
            });
        }
        else if(item.equals("Bikaner")){

            mRef2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot child: dataSnapshot.getChildren()) {
                        int credit=Integer.parseInt(child.getValue().toString());
                        credit=credit+1;
                        Firebase mRefChild = mRef2.child("Bikaner");
                        mRefChild.setValue(credit);
                    }
                }
                @Override
                public void onCancelled(FirebaseError firebaseError) {

                    Log.e("MainActivity", "onCancelled", firebaseError.toException());
                }
            });
        }
        else if(item.equals("Bundi")){

            mRef2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot child: dataSnapshot.getChildren()) {
                        int credit=Integer.parseInt(child.getValue().toString());
                        credit=credit+1;
                        Firebase mRefChild = mRef2.child("Bundi");
                        mRefChild.setValue(credit);
                    }
                }
                @Override
                public void onCancelled(FirebaseError firebaseError) {

                    Log.e("MainActivity", "onCancelled", firebaseError.toException());
                }
            });
        }
        else if(item.equals("Jaipur")){

            mRef2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot child: dataSnapshot.getChildren()) {
                        int credit=Integer.parseInt(child.getValue().toString());
                        credit=credit+1;
                        Firebase mRefChild = mRef2.child("Jaipur");
                        mRefChild.setValue(credit);
                    }
                }
                @Override
                public void onCancelled(FirebaseError firebaseError) {

                    Log.e("MainActivity", "onCancelled", firebaseError.toException());
                }
            });
        }
        Toast.makeText(adapterView.getContext(), "Selected Village will get 1 Credit: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
