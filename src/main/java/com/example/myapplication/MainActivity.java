package com.example.myapplication;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

        SAXParserFactory factory = SAXParserFactory.newInstance();
        GPXReader handler = null;

        try {
            SAXParser saxParser = factory.newSAXParser();

            handler = new GPXReader();
            saxParser.parse(is, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView tw = findViewById(R.id.helloworld);
        assert handler != null;

        List<Point> listPoints = handler.getGeneratedPoints();
        tw.setText(listPoints.toString());
    }
}