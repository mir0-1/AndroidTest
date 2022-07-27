package com.example.myapplication;

import android.util.Log;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;
import java.util.List;

public class GPXReader extends DefaultHandler {
    private GPXTag currentTagWithData = GPXTag.NONE;

    private List<Point> generatedPoints = new LinkedList<>();

    private double lat;

    private double lon;

    private double zoomLevel;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("rtept") && currentTagWithData == GPXTag.NONE) {
            lat = Double.parseDouble(attributes.getValue("lat"));
            lon = Double.parseDouble(attributes.getValue("lon"));
            currentTagWithData = GPXTag.RTEPT;
        }

        if (qName.equals("ele") && currentTagWithData == GPXTag.RTEPT) {
            currentTagWithData = GPXTag.ELE;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("rtept") && currentTagWithData == GPXTag.ELE) {
            zoomLevel = Double.parseDouble(stringBuilder.toString());
            generatedPoints.add(new Point(lat, lon, zoomLevel));
            currentTagWithData = GPXTag.NONE;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (currentTagWithData == GPXTag.ELE) {
            stringBuilder.append(ch, start, length);
        }
        else
            stringBuilder.setLength(0);
    }

    public List<Point> getGeneratedPoints() {
        return generatedPoints;
    }
}
