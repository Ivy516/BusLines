package com.example.busline.bean;

public class Route {
    private int position;
    private String stop;
    private int isArrived;
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getIsArrived() {
        return isArrived;
    }

    public void setIsArrived(int isArrived) {
        this.isArrived = isArrived;
    }
}
