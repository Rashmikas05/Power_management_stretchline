package com.rtm.logingiot;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public  class Menu extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_2);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button1.setOnClickListener(v -> startActivity(new Intent(Menu.this, Powermanagement.class)));
        button3.setOnClickListener(v -> startActivity(new Intent(Menu.this, Compressor.class)));
        button4.setOnClickListener(v -> startActivity(new Intent(Menu.this, Other.class)));
        button2.setOnClickListener(v -> startActivity(new Intent(Menu.this, Airec.class)));
        button5.setOnClickListener(v -> startActivity(new Intent(Menu.this, LogNotes.class)));


    }


    @Override
    public void onClick(View view) {

    }
}

    