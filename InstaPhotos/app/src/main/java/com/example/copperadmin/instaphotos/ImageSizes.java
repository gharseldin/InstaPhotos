package com.example.copperadmin.instaphotos;

/**
 * Created by Copper Admin on 10/5/2014.
 */
public class ImageSizes {
    private StandardResolution mstandard;
    private Thumbnail mthumbnail;
    private LowResolution mlow;

    public StandardResolution getMstandard() {
        return mstandard;
    }

    public void setMstandard(StandardResolution mstandard) {
        this.mstandard = mstandard;
    }

    public Thumbnail getMthumbnail() {
        return mthumbnail;
    }

    public void setMthumbnail(Thumbnail mthumbnail) {
        this.mthumbnail = mthumbnail;
    }

    public LowResolution getMlow() {
        return mlow;
    }

    public void setMlow(LowResolution mlow) {
        this.mlow = mlow;
    }
}
