package com.example.macbook.scuber;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lincolnwhite on 7/22/17.
 */

public class CardFragment extends Fragment {


    private static final String ARG_POSITION = "position";

    private int position;

    public static CardFragment newInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (position == 0) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        } else {
            View rootView = inflater.inflate(R.layout.fragment_my_rides, container, false);
            return rootView;
        }

    }

}