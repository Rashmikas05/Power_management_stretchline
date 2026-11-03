package com.rtm.logingiot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Coolingtower2 extends AppCompatActivity {


    private DatabaseReference mDatabase;

    Button coolon;
    Button cooloff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.coolingtower2);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        coolon = (Button) findViewById(R.id.coolon);
        cooloff = (Button) findViewById(R.id.cooloff);

        coolon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.child("CoolTABM1").setValue(true);
            }
        });

        cooloff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.child("CoolTABM1").setValue(false);
            }
        });




    }
}