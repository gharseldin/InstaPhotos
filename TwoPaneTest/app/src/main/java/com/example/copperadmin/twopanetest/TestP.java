package com.example.copperadmin.twopanetest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Copper Admin on 10/7/2014.
 */
public class TestP implements Parcelable {
    int a;
    String b;
    String c;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.a);
        dest.writeString(this.b);
        dest.writeString(this.c);
    }

    public TestP() {
    }

    private TestP(Parcel in) {
        this.a = in.readInt();
        this.b = in.readString();
        this.c = in.readString();
    }

    public static final Creator<TestP> CREATOR = new Creator<TestP>() {
        public TestP createFromParcel(Parcel source) {
            return new TestP(source);
        }

        public TestP[] newArray(int size) {
            return new TestP[size];
        }
    };
}
