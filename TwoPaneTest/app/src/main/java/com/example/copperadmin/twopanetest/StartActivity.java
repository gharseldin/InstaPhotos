package com.example.copperadmin.twopanetest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;


public class StartActivity extends SingleFragmentActivity{


    @Override
    protected Fragment createFragment(){
        return new EditorFragment();
    }

}
