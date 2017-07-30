package com.example.macbook.scuber;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getApplicationContext().getSharedPreferences("login", getApplicationContext().MODE_PRIVATE);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_splash);
        String email = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");
        if(!email.equals("") && !password.equals("")) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                ToMaps();
                            } else {
                                ToLogin();
                            }

                        }
                    });
        }else{
            ToLogin();
        }
    }



    public void ToLogin(){
        Intent i = new Intent(getApplicationContext(),Login.class);
        startActivity(i);
    }

    public void ToMaps(){
        Intent i = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(i);
    }
}
