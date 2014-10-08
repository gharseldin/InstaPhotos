package com.example.copperadmin.twopanetest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class TopPaneFragment extends Fragment {

    public static final String EXTRA_PARSER="com.example.copperadmin.twopanetest.parser";
    private static final String DIALOG_DATE = "date";

    private EditText mScreenEditText;
    private Button mSendButton;
    private TextParser mTextParser;


    public TopPaneFragment() {
        // Required empty public constructor
    }

    public static TopPaneFragment newInstance(TextParser textParser){
        
        Bundle args = new Bundle();
        args.putParcelable(EditorFragment.EXTRA_PARSED_TEXT, textParser);
        TopPaneFragment fragment = new TopPaneFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTextParser = (TextParser)getArguments().getParcelable(EditorFragment.EXTRA_PARSED_TEXT);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_pane, container, false);

        mScreenEditText = (EditText)view.findViewById(R.id.edit_text_screen);
        mScreenEditText.setText("Name = "+mTextParser.getName()+"\n");
        mScreenEditText.append("Age = "+mTextParser.getAge()+"\n");
        mScreenEditText.append("Date of Birth = "+mTextParser.getDateOfBirth());

        mSendButton = (Button)view.findViewById(R.id.button_send);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        mScreenEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mTextParser);
                dialog.show(fm, DIALOG_DATE);
            }
        });
        return view;
    }

}
