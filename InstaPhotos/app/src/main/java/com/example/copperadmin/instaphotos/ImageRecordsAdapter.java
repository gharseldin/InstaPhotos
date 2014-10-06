package com.example.copperadmin.instaphotos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by Copper Admin on 10/6/2014.
 */
public class ImageRecordsAdapter extends ArrayAdapter<String> {

    private ImageLoader mImageLoader;

    public ImageRecordsAdapter(Context context) {
        super(context, R.layout.image_list_item);

        mImageLoader = new ImageLoader(VolleyApplication.getInstance().getRequestQueue(), new BitmapLruCache());

    }

    public void swapImageRecords(String[] urls) {
        clear();

        for(String url : urls) {
            add(url);
        }

        notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.image_list_item, parent, false);
        }

        // NOTE: You would normally use the ViewHolder pattern here
        NetworkImageView imageView = (NetworkImageView) convertView.findViewById(R.id.image1);

        String imageUrl = getItem(position);

        imageView.setImageUrl(imageUrl, mImageLoader);

        return convertView;
    }

}
