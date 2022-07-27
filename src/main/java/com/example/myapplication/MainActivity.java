package com.example.myapplication;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream is = null;
        try {
            is = getAssets().open("route_2_BTsS.gpx");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner s = new Scanner(is).useDelimiter("\\*");
        String result = s.hasNext() ? s.next() : "";

        TextView tw = findViewById(R.id.helloworld);
        tw.setText(result);
    }
}