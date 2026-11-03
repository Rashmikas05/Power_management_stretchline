package com.rtm.logingiot;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Airec extends AppCompatActivity {


    private TextView air1;
    private TextView air2;
    private TextView air3;


    private static final String CHANNEL_ID = "Rashmika";
    private static final String CHANNEL_NAME = "srimal";
    private static final String CHANNEL_DESC = "rtm";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_airec);

        ImageButton button1 = findViewById(R.id.towerButton);
        ImageButton button2 = findViewById(R.id.towerButton2);

        button1.setOnClickListener(v -> startActivity(new Intent(Airec.this, Coolingtower2.class)));
        button2.setOnClickListener(v -> startActivity(new Intent(Airec.this, Coolingtower.class)));





        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }




        air1 = findViewById(R.id.ac1);
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("ac1");

        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        long valuve = Objects.requireNonNull(snapshot.getValue()).hashCode();
                        String  valuves =String.valueOf(valuve);
                        air1.setText(valuves);
                        if(valuve >= 28){
                            AConenoty1();
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }



        air2 = findViewById(R.id.ac2);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("ac2");

        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        long valuve = Objects.requireNonNull(snapshot.getValue()).hashCode();
                        String  valuves =String.valueOf(valuve);
                        air2.setText(valuves);
                        if(valuve >= 28){
                            AConenoty2();
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }




        air3 = findViewById(R.id.ac3);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("ac3");
        {
            rootDatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        long valuve = Objects.requireNonNull(snapshot.getValue()).hashCode();
                        String  valuves =String.valueOf(valuve);
                        air3.setText(valuves);
                        if(valuve >= 28) {
                            AConenoty3();
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }






    }









    private void AConenoty1() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.stretch1)
                .setContentTitle("AC Warning")
                .setContentText("The Building A is faulty")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mnotimgr = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mnotimgr.notify(1, mBuilder.build());
    }




    private void AConenoty2() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.stretch1)
                .setContentTitle("AC Warning")
                .setContentText("The Building B package is faulty")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mnotimgr = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mnotimgr.notify(2, mBuilder.build());
    }

    private void AConenoty3() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.stretch1)
                .setContentTitle("AC Warning")
                .setContentText("The Valuve Addition package is faulty")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mnotimgr = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mnotimgr.notify(3, mBuilder.build());
    }








}

