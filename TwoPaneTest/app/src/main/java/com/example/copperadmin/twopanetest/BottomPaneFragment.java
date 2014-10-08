package com.example.copperadmin.twopanetest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class BottomPaneFragment extends Fragment {

    private TextView mScreenTextView;
    private TextParser mTextParser;

    public BottomPaneFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(TextParser textParser){

        Bundle args = new Bundle();
        args.putParcelable(TopPaneFragment.EXTRA_PARSER,textParser);
        Fragment fragment = new BottomPaneFragment();
        fragment.setArguments(args);

        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTextParser = (TextParser)getArguments().getParcelable(TopPaneFragment.EXTRA_PARSER);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_pane, container, false);

        mScreenTextView = (TextView)view.findViewById(R.id.text_view_screen);
        parseToScreen();



        return view;
    }

    private void parseToScreen(){
        mScreenTextView.setText("Name = "+mTextParser.getName()+"\n");
        mScreenTextView.append("Age = "+mTextParser.getAge()+"\n");
        mScreenTextView.append("Date of Birth = "+mTextParser.getDateOfBirth());
    }
}
