package com.rtm.logingiot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Compressor extends AppCompatActivity {

    private TextView Bar;
    private TextView Temp;
    private TextView Status;
    private TextView barC10;
    private TextView tempC10;
    private TextView statusC10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.compressorxml);


        Bar = findViewById(R.id.textView9);
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("C-30-compressor-Bar");

        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        String data= Objects.requireNonNull(snapshot.getValue()).toString();
                        Bar.setText(data);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });
        }



        Temp = findViewById(R.id.textView11);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("C-30-Compressor-Temp");


        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        String data= Objects.requireNonNull(snapshot.getValue()).toString();
                        Temp.setText(data);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }


        Status = findViewById(R.id.textView8);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("C-30-Compressor-Run-Status");

        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        String data= Objects.requireNonNull(snapshot.getValue()).toString();
                        Status.setText(data);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });
        }



        barC10 = findViewById(R.id.textView13);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("C-10-Compressor-Bar");


        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        String data= Objects.requireNonNull(snapshot.getValue()).toString();
                        barC10.setText(data);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }






        tempC10 = findViewById(R.id.textView15);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("C-10-Compressor-Temp");


        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        String data= Objects.requireNonNull(snapshot.getValue()).toString();
                        tempC10.setText(data);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }






        statusC10 = findViewById(R.id.textView17);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("C-10-Compressor-status");


        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        String data= Objects.requireNonNull(snapshot.getValue()).toString();
                        statusC10.setText(data);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }











    }











}

