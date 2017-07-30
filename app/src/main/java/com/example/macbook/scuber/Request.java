package com.example.macbook.scuber;

/**
 * Created by macbook on 22-07-17.
 */

public class Request {
    String userID;
    double lat1;
    double lng1;
    double lat2;
    double lng2;
    boolean accepted;
    String token;

    public Request(){

    }
    public Request(String ID, double lt1, double lg1, double lt2, double lg2, boolean acpt, String t){
        userID = ID;
        lat1 = lt1;
        lng1 = lg1;
        lat2 = lt2;
        lng2 = lg2;
        accepted = acpt;
        token = t;
    }
}
