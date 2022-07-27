package com.example.myapplication;

public class Point {
    double lat;
    double lon;
    double zoomLevel;

    public Point(double lat, double lon, double zoomLevel) {
        this.lat = lat;
        this.lon = lon;
        this.zoomLevel = zoomLevel;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setZoomLevel(double zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    @Override
    public String toString() {
        return "Point{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", zoomLevel=" + zoomLevel +
                '}';
    }
}
