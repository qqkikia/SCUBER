package com.example.macbook.scuber;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by macbook on 22-07-17.
 */

public class DatabaseHandler {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public DatabaseHandler(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }


    public void UpdateUserLocation(User user, double lat, double lng){

    }

    public void SendRequest(Request request){
databaseReference.child("PendingRequests").child(request.userID).child("Request").setValue(request);
    }

    public void RegisterUser(User user){

    }

}
