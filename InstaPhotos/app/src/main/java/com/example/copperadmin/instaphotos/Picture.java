package com.example.copperadmin.instaphotos;

import android.media.Image;

/**
 * Created by Copper Admin on 10/5/2014.
 */
public class Picture {

    private String mId;
    private String mType;
    private String mFilter;

    private ImageSizes mImageSizes;

    private Caption mCaption;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getFilter() {
        return mFilter;
    }

    public void setFilter(String filter) {
        mFilter = filter;
    }

    public ImageSizes getImageSizes() {
        return mImageSizes;
    }

    public void setImageSizes(ImageSizes imageSizes) {
        mImageSizes = imageSizes;
    }

    public Caption getCaption() {
        return mCaption;
    }

    public void setCaption(Caption caption) {
        mCaption = caption;
    }
}
