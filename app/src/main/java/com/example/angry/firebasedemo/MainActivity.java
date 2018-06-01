package com.example.angry.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.Reference;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkUI();
        logicsHere();
    }

    private void logicsHere() {
        final FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=database.getReference("naam");
        databaseReference.setValue("Devrari");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                Log.w("$$$$$",""+value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("$$$$$",""+databaseError.toException());
            }
        });
    }

    private void linkUI() {
        textView=findViewById(R.id.textDemo);
    }
}
