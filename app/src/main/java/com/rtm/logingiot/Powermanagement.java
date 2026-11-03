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

public class Powermanagement extends AppCompatActivity {


    private TextView GenAvail;
    private TextView GenRun;
    private TextView CEBRun;
    private TextView CEBAvai;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.powermanagement);


        GenAvail = findViewById(R.id.text41);
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("GenAvail");

        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        String data= Objects.requireNonNull(snapshot.getValue()).toString();
                        GenAvail.setText(data);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });
        }




        GenRun = findViewById(R.id.textViewrun);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("GenRun");

        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        String data= Objects.requireNonNull(snapshot.getValue()).toString();
                        GenRun.setText(data);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });
        }







        CEBAvai = findViewById(R.id.textView5);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("CEBAvai");

        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        String data= Objects.requireNonNull(snapshot.getValue()).toString();
                        CEBAvai.setText(data);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });
        }









        CEBRun = findViewById(R.id.textView6);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("CEBRun");

        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        String data= Objects.requireNonNull(snapshot.getValue()).toString();
                        CEBRun.setText(data);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });
        }









    }
}