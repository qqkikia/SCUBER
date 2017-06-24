package com.example.macbook.scuber;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyAndroidFCMIIDService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        FirebaseMessaging.getInstance().subscribeToTopic("GLOBALgroup");

        // sendRegistrationToServer(refreshedToken);   Your METHOD to save TOKENS
    }
    private void sendRegistrationToServer(String token) {
        //Implement this method if you want to store the token on your server
    }
}