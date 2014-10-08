package com.example.copperadmin.twopanetest;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Copper Admin on 10/7/2014.
 */
public class TestHasP implements Parcelable {
    TestP x;
    String a;
    String b;
    List<String> list;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.x, 0);
        dest.writeString(this.a);
        dest.writeString(this.b);
        dest.writeList(this.list);
    }

    public TestHasP() {
    }

    private TestHasP(Parcel in) {
        this.x = in.readParcelable(TestP.class.getClassLoader());
        this.a = in.readString();
        this.b = in.readString();
        this.list = new ArrayList<String>();
        in.readList(this.list,null);
    }

    public static final Creator<TestHasP> CREATOR = new Creator<TestHasP>() {
        public TestHasP createFromParcel(Parcel source) {
            return new TestHasP(source);
        }

        public TestHasP[] newArray(int size) {
            return new TestHasP[size];
        }
    };
}
