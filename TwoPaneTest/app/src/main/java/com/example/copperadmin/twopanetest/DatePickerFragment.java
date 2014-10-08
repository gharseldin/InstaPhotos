package com.example.copperadmin.twopanetest;



import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class DatePickerFragment extends DialogFragment {


    private static final String EXTRA_TEXT_PARSER= "com.example.copperadmin.twopanetest.parsertoDialog";
    private TextParser mTextParser;


    public DatePickerFragment() {
        // Required empty public constructor
    }

    public static DatePickerFragment newInstance(TextParser parser){

        Bundle args = new Bundle();
        args.putParcelable(EXTRA_TEXT_PARSER, parser);

        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setArguments(args);

        return datePickerFragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String dateOfBirth = mTextParser.getDateOfBirth();
        String[] dateOfBirthFields = dateOfBirth.split(" ");
        Calendar calendar = Calendar.getInstance();
        int year = Integer.parseInt(dateOfBirthFields[2]);
        int month = Integer.parseInt(dateOfBirthFields[1]);
        int day = Integer.parseInt(dateOfBirthFields[0]);

        View v = getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_date, null);


        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok,null)
                .create();
    }
}
