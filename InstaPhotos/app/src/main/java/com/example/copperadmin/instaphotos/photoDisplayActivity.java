package com.example.copperadmin.instaphotos;

import android.support.v4.app.Fragment;


public class photoDisplayActivity extends SingleFragmentActivity {

    @Override
    public Fragment getFragment(){
        return new ImagesFragment();
    }
}
