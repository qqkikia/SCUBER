package com.example.macbook.scuber;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private CallbackManager mCallbackManager;
    private String email;
    private String password;
    private SharedPreferences sharedPreferences;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        sharedPreferences = getApplicationContext().getSharedPreferences("login", getApplicationContext().MODE_PRIVATE);
        databaseHandler = new DatabaseHandler();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }


    public void SignInUser(View view){
        EditText emailEdit = (EditText)findViewById(R.id.email);
        EditText passwordEdit = (EditText)findViewById(R.id.password);
        email = emailEdit.getText().toString();
        password = passwordEdit.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            UpdateSharedPref(email,password);
                            Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                            startActivity(i);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TagFailure", "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Whoops, email and/or password is wrong",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


    public void UpdateSharedPref(String e, String p){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email",e);
        editor.putString("password",p);
        editor.commit();
    }


}
