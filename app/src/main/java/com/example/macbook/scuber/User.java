package com.example.macbook.scuber;

/**
 * Created by macbook on 22-07-17.
 */

public class User {
    String name;
    String userID;
    double lat;
    double lng;

    public User(){

    }
    public User(String n, String ID, double lt, double lg){
        name = n;
        userID = ID;
        lat = lt;
        lng = lg;
    }
}
