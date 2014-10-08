package com.example.copperadmin.twopanetest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Copper Admin on 10/7/2014.
 */
public abstract class TwoVerticalFragmentActivity extends ActionBarActivity {

    abstract Fragment createTopFragment();
    abstract Fragment createBottomFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_vertical_fragments);


        FragmentManager fm = getSupportFragmentManager();

        Fragment topFragment;
        Fragment bottomFragment;

        topFragment = fm.findFragmentById(R.id.top_pane);
        bottomFragment = fm.findFragmentById(R.id.bottom_pane);

        if (topFragment == null) {
            topFragment = createTopFragment();
            fm.beginTransaction().add(R.id.top_pane, topFragment).commit();
        }

        if (bottomFragment == null) {
            bottomFragment = createBottomFragment();
            fm.beginTransaction().add(R.id.bottom_pane, bottomFragment).commit();
        }
    }
}
