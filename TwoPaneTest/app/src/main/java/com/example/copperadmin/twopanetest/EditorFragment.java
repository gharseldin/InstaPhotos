package com.example.copperadmin.twopanetest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class EditorFragment extends Fragment {

    public static final String EXTRA_PARSED_TEXT = "com.example.copperadmin.twopanetest.text_to_parse";
    private EditText mScreenEditText;
    private Button mSendButton;
    private TextParser mTextParser;

    public EditorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_pane, container, false);

        mScreenEditText = (EditText)view.findViewById(R.id.edit_text_screen);
        mSendButton = (Button)view.findViewById(R.id.button_send);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextParser = new TextParser(mScreenEditText.getText().toString());

                Intent i = new Intent(getActivity(),DataPassingActivity.class);
                i.putExtra(EditorFragment.EXTRA_PARSED_TEXT,mTextParser);
                TextParser bottomParser = new TextParser("Ahmed\n15\n14/2/1984");
                i.putExtra(TopPaneFragment.EXTRA_PARSER,bottomParser);
                startActivity(i);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0){
            mScreenEditText.setText("I got it Start Over!");
        }
    }
}
