package com.example.copperadmin.twopanetest;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Copper Admin on 10/7/2014.
 */
public class TextParser implements Parcelable{

    private String mName;
    private int mAge;
    private String mDateOfBirth;

    public TextParser(String inputText) {
        String[] lines = inputText.split("\n");
        for (String x : lines) {
            mName = lines[0];
            mAge = Integer.parseInt(lines[1]);
            mDateOfBirth = lines[2];
        }
    }

    public TextParser(Parcel in){
        this.mName = in.readString();
        this.mAge = in.readInt();
        this.mDateOfBirth = in.readString();
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {


        parcel.writeString(mName);
        parcel.writeInt(mAge);
        parcel.writeString(mDateOfBirth);
    }

    public static final Parcelable.Creator<TextParser> CREATOR
            = new Parcelable.Creator<TextParser>() {
        public TextParser createFromParcel(Parcel in) {
            return new TextParser(in);
        }

        public TextParser[] newArray(int size) {
            return new TextParser[size];
        }
    };
}
