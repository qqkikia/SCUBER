package com.example.macbook.scuber;

import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import layout.register1;
import layout.register2;
import layout.register3;

public class RegisterActivity extends AppCompatActivity {

    ViewPager mViewPager;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mViewPager = (ViewPager) findViewById(R.id.pager);
/** set the adapter for ViewPager */
        mViewPager.setAdapter(new SamplePagerAdapter(getSupportFragmentManager()));

        String email;
        String password;
        String passwordCheck;
    }


    /**
     * Defining a FragmentPagerAdapter class for controlling the fragments to be shown when user swipes on the screen.
     */
    public class SamplePagerAdapter extends FragmentPagerAdapter {

        public SamplePagerAdapter(android.support.v4.app.FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            /** Show a Fragment based on the position of the current screen */
            if (position == 0) {
                return new register1();
            } else if (position == 1) {
                return new register2();
            } else
                return new register3();
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 3;
        }
    }


    public void RegisterUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TagSuccess", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TagFailure", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
}
