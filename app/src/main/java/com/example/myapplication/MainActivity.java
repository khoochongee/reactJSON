package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnOpenWebsite;
    private Button btnJSONTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenWebsite=findViewById(R.id.btnOpenWebsite);
        btnJSONTutorial=findViewById(R.id.btnJSONTutorial);

        btnOpenWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this, "Loading", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"));
                startActivity(i);
            }
        });
        btnJSONTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, JSONTutorial.class);
                startActivity(i);
            }
        });
    }
}
