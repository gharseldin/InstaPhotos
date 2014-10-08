package com.example.copperadmin.twopanetest;

import android.support.v4.app.Fragment;


public class DataPassingActivity extends TwoVerticalFragmentActivity {


    @Override
    Fragment createTopFragment() {
        TextParser textParser = (TextParser) getIntent().getParcelableExtra(EditorFragment.EXTRA_PARSED_TEXT);
        return TopPaneFragment.newInstance(textParser);
    }

    @Override
    Fragment createBottomFragment() {

        TextParser textParser = (TextParser) getIntent().getParcelableExtra(TopPaneFragment.EXTRA_PARSER);

        return BottomPaneFragment.newInstance(textParser);
    }
}