package com.example.busline.bean;

public class Route {
    private int position;
    private int isArrived;
    private String stop;

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

    public void setIsArrived(int route) {
        this.isArrived = isArrived;
    }
}
